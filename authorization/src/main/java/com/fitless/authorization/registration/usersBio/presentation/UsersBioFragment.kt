package com.fitless.authorization.registration.usersBio.presentation

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.authorization.R
import com.fitless.authorization.databinding.FragmentUsersBioBinding
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
        binding.weightUnit.text = state.weightUnit
        binding.heightUnit.text = state.heightUnit

        if(state.genderEmpty != null){
            binding.genderEditTxt.error = state.genderEmpty
        }
        if (state.birthdateEmpty != null){
            binding.dataOfBirthEditTxt.error = state.birthdateEmpty
        }
        if (state.weightEmpty != null){
            binding.weightEditTxt.error = state.weightEmpty
        }
        if(state.heightEmpty != null){
            binding.heightEditTxt.error = state.heightEmpty
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.genderEditTxt.setAdapter(
            ArrayAdapter(requireContext(),
                R.layout.gender_drop_down,
                listOf("Male", "Female")
            )
        )

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

        binding.nextBtn.setOnClickListener { submitData() }

    }

    private fun submitData(){
        reducer.submitAction(
            UserBioAction.SubmitBio(
                gender = binding.genderEditTxt.text.toString(),
                birthdate = binding.dataOfBirthEditTxt.text.toString(),
                weight = binding.weightEditTxt.text.toString(),
                weightUnit = binding.weightUnit.text.toString(),
                height = binding.heightEditTxt.text.toString(),
                heightUnit = binding.heightUnit.text.toString()
            )
        )
    }

    private fun datePickerDialog(){
        val getDate = Calendar.getInstance()
        val datePicker = DatePickerDialog(
            requireContext(), 
            android.R.style.Theme_Holo_Light_Dialog_MinWidth,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
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