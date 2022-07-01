package com.example.homekliring.ui.Auth.Authentication.Changepassword

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homekliring.MainActivity
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentChangepasswordBinding
import com.example.homekliring.utils.Resource
import com.google.android.material.snackbar.Snackbar

class ChangeProfilFragment : Fragment() {
    private var _binding: FragmentChangepasswordBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentChangepasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnSave2.setOnClickListener {
                findNavController().navigate(R.id.action_changepassword_to_profilFragment)
            }
            btnBack12.setOnClickListener {
                findNavController().navigate(R.id.action_changepassword_to_edit_profil)
            }


        }
    }

}