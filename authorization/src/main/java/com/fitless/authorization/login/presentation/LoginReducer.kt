package com.fitless.authorization.login.presentation

import com.fitless.authorization.login.domain.model.LoginModel
import com.fitless.authorization.login.domain.usecase.LoginUseCase
import com.fitless.authorization.navigationScreens.Screens
import com.fitless.common.validation.EmailStatus
import com.fitless.common.validation.ValidEmailUseCase
import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

class LoginReducer(
    private val router: NavigationRouter<FragmentScreen>,
    private val validEmailUseCase: ValidEmailUseCase,
    private val loginUseCase: LoginUseCase,
): BaseReducer<LoginState, LoginAction, LoginSideEffect>(
    initialState = LoginState(
        loginValidationStatus = LoginValidationStatus.LOADING,
    )
) {

    override fun submitAction(action: LoginAction) {
        when(action){
            LoginAction.Register -> router.navigateTo(Screens.registrationFragment())

            is LoginAction.SendEmail -> postState { it.copy(email = action.email) }

            is LoginAction.SendPassword -> postState { it.copy(password = action.password) }

            LoginAction.Submit -> login(stateValue)
        }
    }

    private fun login(data: LoginState){
        val emailStatus = validEmailUseCase(data.email)
        val passwordStatus = data.password.isNotEmpty()
        if(emailStatus == EmailStatus.OK && passwordStatus){
            launch {
                val response = loginUseCase.invoke(LoginModel(data.email, data.password))
                if (response) {
                    postState { it.copy(loginValidationStatus = LoginValidationStatus.OK) }
                    router.navigateTo(Screens.successFragment())
                } else {
                    postState { it.copy(loginValidationStatus = LoginValidationStatus.INCORRECT_CREDENTIALS) }
                }
            }
        }else{
            postState {
                it.copy(
                    validationMessage = "Please, enter correct email address and password"
                )
            }
        }
    }

}