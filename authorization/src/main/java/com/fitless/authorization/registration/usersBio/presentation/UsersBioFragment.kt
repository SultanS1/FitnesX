package com.fitless.authorization.registration.usersBio.presentation

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.authorization.R
import com.fitless.authorization.databinding.FragmentUsersBioBinding
import com.fitless.authorization.registration.usersBio.domain.model.HeightStatus
import com.fitless.authorization.registration.usersBio.domain.model.WeightStatus
import com.fitless.common.extensions.afterTextChanged
import com.fitless.common.validation.TextStatus
import com.fitless.core.view.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class UsersBioFragment :
    BaseFragment<UserBioState, UserBioAction, UserBioSideEffect, FragmentUsersBioBinding>(R.layout.fragment_users_bio) {

    override val binding: FragmentUsersBioBinding by viewBinding()

    override val reducer: UserBioReducer by viewModel()

    override fun render(state: UserBioState) {
        binding.weightUnit.text = state.weightUnit.toString()
        binding.heightUnit.text = state.heightUnit.toString()

        if(state.genderEmpty != TextStatus.OK){
            binding.genderEditTxt.error = state.genderEmpty.toString()
        }
        if (state.birthdateEmpty != TextStatus.OK){
            binding.dataOfBirthEditTxt.error = state.birthdateEmpty.toString()
        }
        if (state.weightEmpty != WeightStatus.OK){
            binding.weightEditTxt.error = state.weightEmpty.toString()
        }
        if(state.heightEmpty != HeightStatus.OK){
            binding.heightEditTxt.error = state.heightEmpty.toString()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.genderEditTxt.setAdapter(
            ArrayAdapter(requireContext(),
                R.layout.gender_drop_down,
                resources.getStringArray(com.fitless.common.R.array.gender)
            )
        )

        setEditTextListeners()

        setClickListeners()
    }

    private fun setClickListeners(){

        binding.dataOfBirthEditTxt.setOnClickListener{ datePickerDialog() }

        binding.weightUnit.setOnClickListener {
            reducer.submitAction(
                UserBioAction.ChangeUnit(binding.weightUnit.text.toString())
            )
        }

        binding.heightUnit.setOnClickListener {
            reducer.submitAction(
                UserBioAction.ChangeUnit(binding.heightUnit.text.toString())
            )
        }

        binding.nextBtn.setOnClickListener { reducer.submitAction(UserBioAction.SubmitBio) }

    }

    private fun setEditTextListeners(){

        binding.genderEditTxt.afterTextChanged {
            reducer.submitAction(UserBioAction.SendGender(it))
        }

        binding.dataOfBirthEditTxt.afterTextChanged {
            reducer.submitAction(UserBioAction.SendBirthDate(it))
        }

        binding.weightEditTxt.afterTextChanged {
            reducer.submitAction(UserBioAction.SendWeight(it))
        }

        binding.heightEditTxt.afterTextChanged {
            reducer.submitAction(UserBioAction.SendHeight(it))
        }

    }

    private fun datePickerDialog(){
        val getDate = Calendar.getInstance()
        val datePicker = DatePickerDialog(
            requireContext(), 
            android.R.style.Theme_Holo_Light_Dialog_MinWidth,
            { _, year, month, dayOfMonth ->
                val selectDate = Calendar.getInstance()
                selectDate.set(Calendar.YEAR, year)
                selectDate.set(Calendar.MONTH, month)
                selectDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val date = SimpleDateFormat("dd MMMM yyyy", Locale.UK).format(selectDate.time)
                binding.dataOfBirthEditTxt.setText(date)
            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
        datePicker.show()
    }

}