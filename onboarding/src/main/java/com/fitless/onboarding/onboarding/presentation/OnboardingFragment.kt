package com.fitless.onboarding.onboarding.presentation

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.core.view.BaseFragment
import com.fitless.onboarding.R
import com.fitless.onboarding.databinding.FragmentOnboardingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardingFragment :
	BaseFragment<OnBoardingViewState, OnBoardingAction, FragmentOnboardingBinding>(R.layout.fragment_onboarding) {

    override val binding: FragmentOnboardingBinding by viewBinding()

    override val reducer: OnBoardingReducer by viewModel()
    override fun render(state: OnBoardingViewState) {
        binding.progressBar.progress = state.progress
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextBtn.setOnClickListener {
            reducer.submitAction(action = OnBoardingAction.OnBoardingStep)
        }
    }
}