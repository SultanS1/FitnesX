package com.fitless.authorization.registration.registration.presentation

import com.fitless.authorization.navigationScreens.Screens
import com.fitless.authorization.registration.registration.domain.model.PasswordStatus
import com.fitless.authorization.registration.registration.domain.model.UserDataModel
import com.fitless.authorization.registration.registration.domain.usecase.ConfirmValidationsUseCase
import com.fitless.authorization.registration.registration.domain.usecase.SaveUserUseCase
import com.fitless.common.validation.ValidEmailUseCase
import com.fitless.common.validation.ValidTextUseCase
import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Reducer responsible for handling registration actions and updating the registration state.
 * This class contains validation logic for registration fields.
 */
class RegistrationReducer(
    private val router: NavigationRouter<FragmentScreen>,
    private val validTextUseCase: ValidTextUseCase,
    private val validEmailUseCase: ValidEmailUseCase,
    private val confirmValidationsUseCase: ConfirmValidationsUseCase,
    private val saveUser: SaveUserUseCase

) : BaseReducer<RegistrationState, RegistrationAction, RegistrationSideEffect>(
    initialState = RegistrationState(registered = false)
) {

    /**
     * Submits a registration action to the reducer and updates the state accordingly.
     * @param action The registration action to be processed.
     */
    override fun submitAction(action: RegistrationAction) {
        when(action){
            is RegistrationAction.Register -> {
                register(action)
            }
            is RegistrationAction.Login -> {
                router.navigateTo(Screens.loginFragment())
            }

        }

    }

    private fun register(data: RegistrationAction.Register){
        val nameStatus = validTextUseCase(data.name)
        val surnameStatus = validTextUseCase(data.surname)
        val emailStatus = validEmailUseCase(data.email)
        val passwordStatus = if (data.password.length < 6) PasswordStatus.TOO_SHORT else PasswordStatus.OK

        if(!confirmValidationsUseCase(nameStatus, surnameStatus, emailStatus, passwordStatus)){
            postState {
                it.copy(
                    invalidName = nameStatus,
                    invalidSurname = surnameStatus,
                    invalidEmail = emailStatus,
                    invalidPassword = passwordStatus
                )
            }
        }else{
            launch {
                saveUser(UserDataModel(data.name, data.surname, data.email, data.password, data.policy))
                router.navigateTo(Screens.usersBioFragment())
            }
        }

    }

}