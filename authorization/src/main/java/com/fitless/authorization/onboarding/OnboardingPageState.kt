package com.fitless.authorization.onboarding

import com.fitless.core.architecture.BaseState

data class OnboardingPageState(
  val step: Int
): BaseState