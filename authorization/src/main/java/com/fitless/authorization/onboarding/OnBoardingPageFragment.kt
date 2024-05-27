package com.fitless.authorization.onboarding

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.authorization.R
import com.fitless.authorization.databinding.FragmentOnBoardingPageBinding
import com.fitless.core.view.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs
import kotlin.math.max

class OnBoardingPageFragment :
    BaseFragment<OnboardingPageState, OnboardingPageAction, OnboardingPageSideEffect,
            FragmentOnBoardingPageBinding>(R.layout.fragment_on_boarding_page) {

    override val binding: FragmentOnBoardingPageBinding by viewBinding()

    override val reducer: OnboardingPageReducer by viewModel()

    private val guideAdapter: GuideAdapter by lazy { GuideAdapter() }

    private val pageTransformer: CompositePageTransformer by lazy { CompositePageTransformer() }

    //test
    private val testData: List<GuideItem> = listOf(
        GuideItem("Improve Shape",
            "I have a low amount of body fat and need / want to build more muscle",
            R.drawable.ic_guide1),
        GuideItem("Lean & Tone",
            "I’m “skinny fat”. look thin but have no shape. I want to add learn muscle in the right way",
            R.drawable.ic_guide2),
        GuideItem("Lose a Fat",
            "I have over 20 lbs to lose. I want to drop all this fat and gain muscle mass",
            R.drawable.ic_guide3),
        )

    override fun render(state: OnboardingPageState) {
        adapterSetUp(state.step)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.confirmButton.setOnClickListener {
            reducer.submitAction(OnboardingPageAction.Confirm)
        }
    }

    private fun adapterSetUp(step: Int){
        binding.guideViewPager.isUserInputEnabled = false
        binding.guideViewPager.adapter = guideAdapter
        guideAdapter.setList(testData)

        binding.guideViewPager.clipToPadding = false
        binding.guideViewPager.clipChildren = false
        binding.guideViewPager.offscreenPageLimit = 3
        binding.guideViewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        pageTransformer.addTransformer(MarginPageTransformer(20))
        pageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = (0.96f + r * 0.05f)

            val absPosition = abs(position)
            page.apply {
                alpha = if (absPosition >= 1) {
                    0.5f
                } else {
                    max(0.5f, 1 - absPosition)
                }
            }
        }

        binding.guideViewPager.currentItem = step
        binding.guideViewPager.setPageTransformer(pageTransformer)

    }

}