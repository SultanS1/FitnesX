package com.fitless.authorization.registration.usersBio.presentation

import com.fitless.core.architecture.BaseAction

/**
 * Sealed interface representing different user bio actions in the application.
 */
sealed interface UserBioAction : BaseAction {

    /**
     * Action to change the unit of measurement.
     *
     * @property unit The new unit of measurement (e.g., "KG", "LB", "CM", "FT").
     */
    data class ChangeUnit(val unit: String) : UserBioAction

    /**
     * Action to send the user's gender.
     *
     * @property gender The gender of the user (e.g., "Male", "Female").
     */
    data class SendGender(val gender: String) : UserBioAction

    /**
     * Action to send the user's birth date.
     *
     * @property birthDate The birth date of the user in the format "yyyy-MM-dd".
     */
    data class SendBirthDate(val birthDate: String) : UserBioAction

    /**
     * Action to send the user's weight.
     *
     * @property weight The weight of the user as a String, which may need to be parsed to a numerical value.
     */
    data class SendWeight(val weight: String) : UserBioAction

    /**
     * Action to send the user's height.
     *
     * @property height The height of the user as a String, which may need to be parsed to a numerical value.
     */
    data class SendHeight(val height: String) : UserBioAction

    /**
     * Action to submit the user's bio.
     */
    data object SubmitBio : UserBioAction

}
