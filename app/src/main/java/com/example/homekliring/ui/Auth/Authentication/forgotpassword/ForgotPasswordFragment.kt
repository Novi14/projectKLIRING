package com.example.homekliring.ui.Auth.Authentication.forgotpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homekliring.databinding.FragmentForgotPassword2Binding
import com.example.homekliring.R
class ForgotPasswordFragment : Fragment() {
    private var _binding: FragmentForgotPassword2Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentForgotPassword2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnSand.setOnClickListener {
                findNavController().navigate(R.id.action_forgotPasswordFragment2_to_riset_passwordFragment2)
            }

            tvLogIn.setOnClickListener {
                findNavController().navigate(R.id.action_forgotPasswordFragment2_to_loginFragment)
            }
        }
    }
}






