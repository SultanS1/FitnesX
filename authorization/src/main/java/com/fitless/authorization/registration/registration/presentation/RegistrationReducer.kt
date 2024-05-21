package com.fitless.authorization.registration.registration.presentation

import com.fitless.authorization.navigationScreens.Screens
import com.fitless.authorization.registration.registration.domain.model.UserDataModel
import com.fitless.authorization.registration.registration.domain.usecase.SaveUserUseCase
import com.fitless.authorization.registration.registration.domain.usecase.ValidEmail
import com.fitless.authorization.registration.registration.domain.usecase.ValidName
import com.fitless.authorization.registration.registration.domain.usecase.ValidPassword
import com.fitless.authorization.registration.registration.domain.usecase.ValidSurname
import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Reducer responsible for handling registration actions and updating the registration state.
 * This class contains validation logic for registration fields.
 */
class RegistrationReducer(
    private val router: NavigationRouter<FragmentScreen>,
    private val validName: ValidName,
    private val validSurname: ValidSurname,
    private val validEmail: ValidEmail,
    private val validPassword: ValidPassword,
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
        val nameStatus = validName(data.name)
        val surnameStatus = validSurname(data.surname)
        val emailStatus = validEmail(data.email)
        val passwordStatus = validPassword(data.password)

        val isError = listOf(nameStatus, surnameStatus, emailStatus, passwordStatus).any{
            it != null
        }

        if(isError){
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
            postState {
                it.copy(
                    invalidName = null,
                    invalidSurname = null,
                    invalidEmail = null,
                    invalidPassword = null,
                    registered = true
                )
            }
        }

    }

}