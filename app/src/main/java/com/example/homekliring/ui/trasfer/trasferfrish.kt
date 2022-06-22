package com.example.homekliring.ui.trasfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentTrasferfisrtBinding

class trasferfrish : Fragment() {

    private var _binding: FragmentTrasferfisrtBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTrasferfisrtBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnContinue2.setOnClickListener {
                findNavController().navigate(R.id.action_trasferfisrtFragment_to_trsfermetodeFragment)
            }

        }
    }
}