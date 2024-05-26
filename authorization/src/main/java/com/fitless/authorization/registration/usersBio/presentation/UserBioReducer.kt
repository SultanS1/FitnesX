package com.fitless.authorization.registration.usersBio.presentation

import com.fitless.authorization.navigationScreens.Screens
import com.fitless.authorization.registration.usersBio.domain.model.UserBioModel
import com.fitless.authorization.registration.usersBio.domain.usecase.SaveUserBioUseCase
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidHeightUseCase
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidWeightUseCase
import com.fitless.authorization.registration.usersBio.domain.usecase.ValidationConfirmUseCase
import com.fitless.common.validation.ValidTextUseCase
import com.fitless.core.architecture.BaseReducer
import com.fitless.core.navigation.NavigationRouter
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserBioReducer(
    private val router: NavigationRouter<FragmentScreen>,
    private val saveUserBioUseCase: SaveUserBioUseCase,
    private val validGenderUseCase: ValidTextUseCase,
    private val validBirthDateUseCase:  ValidTextUseCase,
    private val validWeightUseCase: ValidWeightUseCase,
    private val validHeightUseCase: ValidHeightUseCase,
    private val validationConfirmUseCase: ValidationConfirmUseCase
): BaseReducer<UserBioState, UserBioAction, UserBioSideEffect>(
    initialState = UserBioState()
) {

    override fun submitAction(action: UserBioAction) {
        when(action){

            is UserBioAction.ChangeUnit -> { setUnits(action.unit) }

            is UserBioAction.SubmitBio -> { moveForward(stateValue)}

            is UserBioAction.SendBirthDate -> postState { it.copy(birthdate = action.birthDate) }

            is UserBioAction.SendGender -> postState { it.copy(gender = action.gender) }

            is UserBioAction.SendHeight -> postState { it.copy(height = action.height) }

            is UserBioAction.SendWeight -> postState { it.copy(weight = action.weight) }
        }
    }

    private fun moveForward(data: UserBioState){
        val genderStatus = validGenderUseCase(data.gender)
        val birthDateStatus = validBirthDateUseCase(data.birthdate)
        val weightStatus = validWeightUseCase(data.weight)
        val heightStatus = validHeightUseCase(data.height)

        if(!validationConfirmUseCase(genderStatus, birthDateStatus, weightStatus, heightStatus)){
            postState {
                it.copy(
                    genderEmpty = genderStatus,
                    birthdateEmpty = birthDateStatus,
                    weightEmpty = weightStatus,
                    heightEmpty = heightStatus
                )
            }
        }else{
            launch {
                saveUserBioUseCase(
                    UserBioModel(
                        data.gender,
                        data.birthdate,
                        data.weight,
                        data.weightUnit.toString(),
                        data.height,
                        data.heightUnit.toString()
                    )
                )
                router.navigateTo(Screens.onBoardingFragment())
            }

        }
    }

    private fun setUnits(unit: String){

        if(unit == "KG") postState { it.copy(weightUnit = WeightUnit.LB) } else postState { it.copy(weightUnit = WeightUnit.KG) }

        if (unit == "CM") postState { it.copy(heightUnit = HeightUnit.FT) } else postState { it.copy(heightUnit = HeightUnit.CM) }

    }

}