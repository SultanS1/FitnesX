package com.fitless.authorization.registration.registration.presentation

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.authorization.R
import com.fitless.authorization.databinding.FragmentRegistrationBinding
import com.fitless.authorization.registration.registration.domain.model.PasswordStatus
import com.fitless.common.validation.EmailStatus
import com.fitless.common.validation.TextStatus
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

        if (state.invalidName != TextStatus.OK){
            binding.firstNameTxt.error = state.invalidName.toString()
        }
        if (state.invalidSurname != TextStatus.OK){
            binding.lastNameTxt.error = state.invalidSurname.toString()
        }
        if (state.invalidEmail != EmailStatus.OK){
            binding.emailTxt.error = state.invalidEmail.toString()
        }
        if (state.invalidPassword != PasswordStatus.OK){
            binding.passwordTxt.error = state.invalidPassword.toString()
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
                name = binding.firstNameTxt.text.toString(),
                surname = binding.lastNameTxt.text.toString(),
                email = binding.emailTxt.text.toString(),
                password = binding.passwordTxt.text.toString(),
                policy = binding.privacyAgreement.isChecked,
                registered = true
            ))
        }

    }

}