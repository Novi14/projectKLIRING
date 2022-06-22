package com.example.homekliring.ui.Auth.Authentication.RisetPassword


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentRisetPassword2Binding

class RisetPassword : Fragment() {
    private var _binding: FragmentRisetPassword2Binding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRisetPassword2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnSubmit.setOnClickListener {
                findNavController().navigate(R.id.action_riset_passwordFragment2_to_loginFragment)
            }
        }
    }
}