package com.example.homekliring.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentNotifikasiBesrhasillogoutBinding


class logoutFragment : Fragment() {

    private var _binding: FragmentNotifikasiBesrhasillogoutBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNotifikasiBesrhasillogoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnYes.setOnClickListener {
                findNavController().navigate(R.id.action_notifikasi_besrhasillogout_to_secondScreenFragment)
            }

            btbNo.setOnClickListener {
                findNavController().navigate(R.id.action_notifikasi_besrhasillogout_to_startFragment2)
            }


        }
    }
}