package com.fitless.authorization.registration.usersBio.presentation

import com.fitless.authorization.navigationScreens.Screens
import com.fitless.authorization.registration.usersBio.domain.model.UserBioModel
import com.fitless.authorization.registration.usersBio.domain.usecase.SaveUserBioUseCase
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidBirthDate
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidGender
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidHeight
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidWeight
import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserBioReducer(
    private val router: NavigationRouter<FragmentScreen>,
    private val saveUserBio: SaveUserBioUseCase,
    private val validGender: ValidGender,
    private val validBirthDate: ValidBirthDate,
    private val validWeight: ValidWeight,
    private val validHeight: ValidHeight
): BaseReducer<UserBioState, UserBioAction, UserBioSideEffect>(
    initialState = UserBioState(weightUnit = "KG", heightUnit = "CM")
) {

    override fun submitAction(action: UserBioAction) {
        when(action){

            is UserBioAction.ChangeUnit -> { setUnits(action.unit) }

            is UserBioAction.SubmitBio -> { moveForward(action)}

        }
    }

    private fun moveForward(data: UserBioAction.SubmitBio){
        val genderStatus = validGender(data.gender)
        val birthDateStatus = validBirthDate(data.birthdate)
        val weightStatus = validWeight(data.weight)
        val heightStatus = validHeight(data.height)
        val isError = listOf(genderStatus, birthDateStatus, weightStatus, heightStatus).any{
            it != null
        }

        if(isError){
            postState {
                it.copy(
                    genderEmpty = genderStatus,
                    birthdateEmpty = birthDateStatus,
                    weightEmpty = weightStatus,
                    heightEmpty = heightStatus
                )
            }
        }else{
            postState {
                it.copy(
                    genderEmpty = null,
                    birthdateEmpty = null,
                    weightEmpty = null,
                    heightEmpty = null
                )
            }

            launch {
                saveUserBio.invoke(
                    UserBioModel(
                        gender = data.gender,
                        birthDate = data.birthdate,
                        weight = data.weight,
                        weightUnit = data.weightUnit,
                        height = data.height,
                        heightUnit = data.heightUnit
                    )
                )
                router.navigateTo(Screens.onBoardingFragment())
            }

        }
    }

    private fun setUnits(unit: String){
        when(unit){
            "KG" -> postState { it.copy(weightUnit = "LB") }
            "LB" -> postState { it.copy(weightUnit = "KG") }
            "CM" -> postState { it.copy(heightUnit = "FT") }
            "FT" -> postState { it.copy(heightUnit = "CM") }
        }
    }

}