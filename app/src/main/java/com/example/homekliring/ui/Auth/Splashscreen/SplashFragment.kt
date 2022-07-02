package com.example.homekliring.ui.Auth.Splashscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homekliring.MainActivity
import com.example.homekliring.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({
            if(onBoardingFinished()) {
                if (registerFinished()) {
                    if (loginFinished() && verificationFinished()) {
                        activity?.startActivity(Intent(activity, MainActivity::class.java))
                        activity?.finish()
                    } else findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                } else findNavController().navigate(R.id.action_splashFragment_to_onboardingViewPagerFragment)
            } else findNavController().navigate(R.id.action_splashFragment_to_onboardingViewPagerFragment)
        }, 3000)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

    private fun registerFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("register", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

    private fun verificationFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("verified", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

    private fun loginFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}