package com.fitless.authorization.registration.registration.presentation

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.authorization.R
import com.fitless.authorization.databinding.FragmentRegistrationBinding
import com.fitless.core.view.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment responsible for user registration.
 * This fragment displays registration fields and handles user input.
 */
class RegistrationFragment :
    BaseFragment<RegistrationState, RegistrationAction, RegistrationSideEffect, FragmentRegistrationBinding>(R.layout.fragment_registration) {

    override val binding: FragmentRegistrationBinding by viewBinding()

    override val reducer: RegistrationReducer by viewModel()

    override fun render(state: RegistrationState) {
        with(binding) {
            firstNameTxt.setText(state.name)
            lastNameTxt.setText(state.surname)
            emailTxt.setText(state.email)
            passwordTxt.setText(state.email)
            privacyAgreement.isChecked = state.policy
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()

    }

    /**
     * Sets click listeners for UI buttons.
     */
    private fun setClickListeners(){

        binding.loginTxtBtn.setOnClickListener { reducer.submitAction(RegistrationAction.Login) }

        binding.registerBtn.setOnClickListener {
            reducer.submitAction(RegistrationAction.Register(
                name = binding.firstNameTxt.toString(),
                surname = binding.lastNameTxt.toString(),
                email = binding.emailTxt.toString(),
                password = binding.passwordTxt.toString(),
                policy = binding.privacyAgreement.isChecked,
                registered = true
            ))
        }

    }

}