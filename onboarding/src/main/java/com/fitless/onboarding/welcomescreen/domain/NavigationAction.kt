package com.fitless.onboarding.welcomescreen.domain

import com.fitless.core.BaseAction

sealed class NavigationAction: BaseAction{
    data object GetStartedBtnClicked: NavigationAction()
}