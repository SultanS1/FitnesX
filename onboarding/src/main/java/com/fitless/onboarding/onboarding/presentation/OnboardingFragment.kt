package com.fitless.onboarding.onboarding.presentation

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.core.view.BaseFragment
import com.fitless.onboarding.R
import com.fitless.onboarding.databinding.FragmentOnboardingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment class for the onboarding screen.
 * Extends [BaseFragment] to handle UI rendering and user interactions.
 *
 * @property binding Instance of [FragmentOnboardingBinding] for accessing views.
 * @property reducer Instance of [OnBoardingReducer] for managing state and actions.
 */
class OnboardingFragment :
	BaseFragment<OnBoardingViewState, OnBoardingAction, OnBoardingSideEffect, FragmentOnboardingBinding>(R.layout.fragment_onboarding) {
	
	override val binding: FragmentOnboardingBinding by viewBinding()
	
	override val reducer: OnBoardingReducer by viewModel()
	override fun render(state: OnBoardingViewState) {
		binding.progressBar.progress = state.progress
		onboardInfo(state.onboardingPassed)
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.nextBtn.setOnClickListener {
			reducer.submitAction(action = OnBoardingAction.OnBoardingStep)
		}
	}

	private fun onboardInfo(onboardingPassed: Int){
		when(onboardingPassed){
			1 -> binding.apply {
				titleImg.setImageResource(R.drawable.ic_onboarding1)
				descriptionTxt.text = resources.getText(com.fitless.common.R.string.onboarding_text1)
			}
			2 -> binding.apply {
				titleImg.setImageResource(R.drawable.ic_onboarding2)
				descriptionTxt.text = resources.getText(com.fitless.common.R.string.onboarding_text2)
			}
			3 -> binding.apply {
				titleImg.setImageResource(R.drawable.ic_onboarding3)
				descriptionTxt.text = resources.getText(com.fitless.common.R.string.onboarding_text3)
			}
			4 -> binding.apply {
				titleImg.setImageResource(R.drawable.ic_onboarding4)
				descriptionTxt.text = resources.getText(com.fitless.common.R.string.onboarding_text4)
			}
		}
	}
}