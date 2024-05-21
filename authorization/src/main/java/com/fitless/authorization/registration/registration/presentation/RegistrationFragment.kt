package com.fitless.authorization.registration.registration.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.authorization.R
import com.fitless.authorization.databinding.FragmentRegistrationBinding
import com.fitless.core.view.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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

        if (state.invalidName != null){
            binding.firstNameTxt.error = state.invalidName
        }
        if (state.invalidSurname != null){
            binding.lastNameTxt.error = state.invalidSurname
        }
        if (state.invalidEmail != null){
            binding.emailTxt.error = state.invalidEmail
        }
        if (state.invalidPassword != null){
            binding.passwordTxt.error = state.invalidPassword
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