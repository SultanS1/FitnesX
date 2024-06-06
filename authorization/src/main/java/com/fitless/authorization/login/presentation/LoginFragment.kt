package com.fitless.authorization.login.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.authorization.R
import com.fitless.authorization.databinding.FragmentLoginBinding
import com.fitless.common.extensions.afterTextChanged
import com.fitless.core.view.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment :
    BaseFragment<LoginState, LoginAction, LoginSideEffect, FragmentLoginBinding>(R.layout.fragment_login) {

    override val binding: FragmentLoginBinding by viewBinding()

    override val reducer: LoginReducer by viewModel()

    override fun render(state: LoginState) {
        if (state.validationMessage.isNotEmpty()){
            Toast.makeText(requireContext(), state.validationMessage, Toast.LENGTH_SHORT).show()
        }
        if(state.loginValidationStatus == LoginValidationStatus.INCORRECT_CREDENTIALS){
            Toast.makeText(requireContext(), state.loginValidationStatus.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textListeners()
        setClickListeners()
    }

    private fun textListeners(){
        binding.emailTxt.afterTextChanged { reducer.submitAction(LoginAction.SendEmail(it)) }
        binding.passwordTxt.afterTextChanged { reducer.submitAction(LoginAction.SendPassword(it)) }
    }

    private fun setClickListeners(){
        binding.registerTxtBtn.setOnClickListener {
            reducer.submitAction(LoginAction.Register)
        }
        binding.loginBtn.setOnClickListener {
            reducer.submitAction(LoginAction.Submit)
        }
    }

}