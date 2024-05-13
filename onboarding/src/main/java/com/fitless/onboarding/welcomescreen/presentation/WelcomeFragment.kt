package com.fitless.onboarding.welcomescreen.presentation

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.core.view.BaseFragment
import com.fitless.onboarding.R
import com.fitless.onboarding.databinding.FragmentWelcomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment for displaying the welcome page.
 */
class WelcomeFragment :
    BaseFragment<WelcomePageViewState, WelcomePageAction, WelcomePageSideEffect,FragmentWelcomeBinding>(R.layout.fragment_welcome) {

    override val binding: FragmentWelcomeBinding by viewBinding()

    override val reducer: WelcomePageReducer by viewModel()

    /**
     * Renders the UI based on the current state.
     * @param state The current state of the welcome page.
     */
    override fun render(state: WelcomePageViewState) {
    }

    /**
     * Called immediately after the view is created.
     * @param view The created view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStartedBtn.setOnClickListener {
            reducer.submitAction(WelcomePageAction.NavigateToNextFragmentAction)
        }
    }

}