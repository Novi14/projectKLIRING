package com.example.homekliring.ui.Auth.Authentication.emailverifikasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homekliring.R
import androidx.navigation.fragment.findNavController
import com.example.homekliring.databinding.FragmentEmailVerifikasiBinding
import com.example.homekliring.ui.Auth.Authentication.register.RegisterFragment

class email_verifikasi : Fragment() {

    private var _binding: FragmentEmailVerifikasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmailVerifikasiBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOK.setOnClickListener {
            findNavController().navigate(R.id.action_email_verifikasiFragment_to_loginFragment)
        }

        binding.btnBackemail.setOnClickListener {
            findNavController().navigate(R.id.action_email_verifikasiFragment_to_registerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
