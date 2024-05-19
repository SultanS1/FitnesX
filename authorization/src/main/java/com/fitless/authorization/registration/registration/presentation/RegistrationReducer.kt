package com.fitless.authorization.registration.registration.presentation

import com.fitless.authorization.navigationScreens.Screens
import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Reducer responsible for handling registration actions and updating the registration state.
 * This class contains validation logic for registration fields.
 */
class RegistrationReducer(
    private val router: NavigationRouter<FragmentScreen>
) : BaseReducer<RegistrationState, RegistrationAction, RegistrationSideEffect>(
    initialState = RegistrationState(name = "", surname = "",
    email = "", password = "", policy = false, registered = false)
) {

    /**
     * Submits a registration action to the reducer and updates the state accordingly.
     * @param action The registration action to be processed.
     */
    override fun submitAction(action: RegistrationAction) {
        when(action){
            is RegistrationAction.Register -> {
                if(validName(action.name) && validSurname(action.surname) && validEmail(action.email) && validPassword(action.password)){
                    postState { state ->
                        state.copy(
                            name = state.name,
                            surname = state.surname,
                            email = state.email,
                            password = state.password,
                            policy = state.policy,
                            registered = state.registered
                        )
                    }
                    router.navigateTo(Screens.usersBioFragment())
                }else{
                    postSideEffect(RegistrationSideEffect.EmptyFields("Empty Fields"))
                }
            }

            is RegistrationAction.Login -> {
                router.navigateTo(Screens.loginFragment())
            }

        }

    }

    /**
     * Validates the name field.
     * @param name The name to be validated.
     * @return True if the name is not empty, false otherwise.
     */
    private fun validName(name: String): Boolean{
        return name.isNotEmpty()
    }

    /**
     * Validates the surname field.
     * @param surname The surname to be validated.
     * @return True if the surname is not empty, false otherwise.
     */
    private fun validSurname(surname: String): Boolean{
        return surname.isNotEmpty()
    }

    /**
     * Validates the email field.
     * @param email The email to be validated.
     * @return True if the email matches the regex pattern, false otherwise.
     */
    private fun validEmail(email: String): Boolean{
        val emailRegex = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+\$")
        return emailRegex.matches(email)
    }

    /**
     * Validates the password field.
     * @param password The password to be validated.
     * @return True if the password length is greater than 3 characters, false otherwise.
     */
    private fun validPassword(password: String): Boolean{
        return password.length > 3
    }

}