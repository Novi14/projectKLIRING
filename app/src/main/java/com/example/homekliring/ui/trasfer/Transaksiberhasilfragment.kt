package com.example.homekliring.ui.trasfer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homekliring.MainActivity
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentTransaksiberhasilBinding


class Transaksiberhasilfragment : Fragment() {

    private var _binding: FragmentTransaksiberhasilBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =FragmentTransaksiberhasilBinding .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            tvBerhasil.setOnClickListener {
                findNavController().navigate(R.id.action_trasaksiberhasil_to_buktitrasferFragment)
            }


        }
    }
}


