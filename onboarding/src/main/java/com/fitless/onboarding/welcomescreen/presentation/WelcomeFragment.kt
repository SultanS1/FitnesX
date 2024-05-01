package com.fitless.onboarding.welcomescreen.presentation

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.core.view.BaseFragment
import com.fitless.onboarding.R
import com.fitless.onboarding.databinding.FragmentWelcomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment : BaseFragment<WelcomePageViewState, WelcomePageAction, FragmentWelcomeBinding>(R.layout.fragment_welcome) {

    override val binding: FragmentWelcomeBinding by viewBinding()

    override val reducer: WelcomePageReducer by viewModel<WelcomePageReducer>()
    override fun render(state: WelcomePageViewState) {
        TODO("Not yet implemented")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStartedBtn.setOnClickListener {
            reducer.submitAction(WelcomePageAction.NavigateToNextFragmentAction)
        }
    }

}