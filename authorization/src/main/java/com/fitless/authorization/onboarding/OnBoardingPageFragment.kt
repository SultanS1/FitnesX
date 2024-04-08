package com.fitless.authorization.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.fitless.authorization.R
import com.fitless.authorization.databinding.FragmentOnBoardingPageBinding

class OnBoardingPageFragment : Fragment(R.layout.fragment_on_boarding_page) {

    private val binding: FragmentOnBoardingPageBinding by viewBinding(CreateMethod.INFLATE)

    private val guideAdapter: GuideRvAdapter by lazy { GuideRvAdapter() }

    private val pageTransformer: CompositePageTransformer by lazy { CompositePageTransformer() }

    private val onboardingGuide: List<GuideItem> = listOf(
        GuideItem("Improve Shape", "I have a low amount of body fat and need / want to build more muscle", R.drawable.ic_guide1),
        GuideItem("Lean & Tone", "I’m “skinny fat”. look thin but have no shape. I want to add learn muscle in the right way", R.drawable.ic_guide2),
        GuideItem("Lose a Fat", "I have over 20 lbs to lose. I want to drop all this fat and gain muscle mass", R.drawable.ic_guide3),
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        guideAdapterSetUp()

    }

    private fun guideAdapterSetUp(){
        binding.guideViewPager.adapter = guideAdapter
        guideAdapter.setList(onboardingGuide)

        binding.guideViewPager.clipToPadding = false
        binding.guideViewPager.clipChildren = false
        binding.guideViewPager.offscreenPageLimit = 3
        binding.guideViewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        pageTransformer.addTransformer(MarginPageTransformer(20))
        pageTransformer.addTransformer(object :ViewPager2.PageTransformer{
            override fun transformPage(page: View, position: Float) {
                val r = 1 - Math.abs(position)
                page.scaleY = (0.96f + r * 0.05f)

                val absPosition = Math.abs(position)
                page.apply {
                    if (absPosition >= 1) {
                        alpha = 0.5f
                    } else {
                        alpha = Math.max(0.5f, 1 - absPosition)
                    }
                }

            }
        })

        binding.guideViewPager.setPageTransformer(pageTransformer)

    }

}