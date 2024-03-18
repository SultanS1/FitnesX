package com.fitless.onboarding.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.onboarding.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private val binding: FragmentOnboardingBinding by viewBinding(CreateMethod.INFLATE)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun changeScreen(){
        // Slide out animation
        val slideOut = TranslateAnimation(
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, -1f,
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 0f
        )
        slideOut.duration = 500
        slideOut.fillAfter = true

        // Slide in animation
        val slideIn = TranslateAnimation(
            Animation.RELATIVE_TO_SELF, 1f,
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 0f
        )
        slideIn.duration = 500
        slideIn.fillAfter = true

        // Set listeners to change text and image after animations
        slideOut.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) = Unit

            override fun onAnimationRepeat(animation: Animation?) = Unit
        })

        // Start animation
        binding.titleTxt.startAnimation(slideOut)
        binding.descriptionTxt.startAnimation(slideOut)
    }

}