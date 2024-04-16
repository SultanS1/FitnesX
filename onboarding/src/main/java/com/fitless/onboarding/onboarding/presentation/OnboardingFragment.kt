package com.fitless.onboarding.onboarding.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.onboarding.databinding.FragmentOnboardingBinding
import com.fitless.onboarding.onboarding.domain.OnBoardingAction
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardingFragment : Fragment() {

    private val binding: FragmentOnboardingBinding by viewBinding(CreateMethod.INFLATE)
    private val viewModel by viewModel<OnBoardingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewState()

        binding.nextBtn.setOnClickListener {
            handleAction()
        }
        binding.descriptionTxt.setOnClickListener {
            handleAction()
        }

    }

    private fun observeViewState(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.viewState.collect { state ->
                when(state.onboardingPassed){
                    1 -> binding.progressBar.progress = 25
                    2 -> binding.progressBar.progress = 50
                    3 -> binding.progressBar.progress = 75
                    4 -> binding.progressBar.progress = 100
                }
            }
        }
    }

    private fun handleAction(){
        if (binding.progressBar.progress == 100){
            viewModel.nextStep(OnBoardingAction.NavigateToAuth)
        }else{
            viewModel.nextStep(OnBoardingAction.OnBoardingStep)
        }
    }

}