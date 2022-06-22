package com.example.homekliring.ui.Auth.Onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homekliring.databinding.FragmentOnboardingViewPagerBinding
import com.example.homekliring.ui.Auth.Onboarding.Screens.FirstScreenFragment
import com.example.homekliring.ui.Auth.Onboarding.Screens.SecondScreenFragment

class OnboardingViewPagerFragment : Fragment() {

    private var _binding: FragmentOnboardingViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnboardingViewPagerBinding.inflate(inflater, container, false)
        val view = binding.root

        val fragmentList = arrayListOf<Fragment>(
            FirstScreenFragment(),
            SecondScreenFragment()
        )

        val adapter = OnboardingViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.onboardingViewpager.adapter = adapter

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}