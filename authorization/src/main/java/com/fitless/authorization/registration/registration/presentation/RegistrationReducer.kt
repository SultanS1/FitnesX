package com.fitless.authorization.registration.registration.presentation

import com.fitless.authorization.navigationScreens.Screens
import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen


class RegistrationReducer(
    private val router: NavigationRouter<FragmentScreen>
) : BaseReducer<RegistrationState, RegistrationAction, RegistrationSideEffect>(
    initialState = RegistrationState(name = "", surname = "",
    email = "", password = "", policy = false, registered = false)
) {

    override fun submitAction(action: RegistrationAction) {
        when(action){
            is RegistrationAction.Register -> {
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
            }

            is RegistrationAction.Login -> {
                router.navigateTo(Screens.loginFragment())
            }

        }

    }

    private fun validName(name: String): Boolean{
        return name.isNotEmpty()
    }

    private fun validSurname(surname: String): Boolean{
        return surname.isNotEmpty()
    }
    private fun validEmail(email: String): Boolean{
        val emailRegex = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+\$")
        return emailRegex.matches(email)
    }
    private fun validPassword(password: String): Boolean{
        return password.length > 3
    }

}