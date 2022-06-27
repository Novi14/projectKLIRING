package com.example.homekliring.ui.trasfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentTrsfermetodeBinding
class trasfermetode : Fragment() {

    private var _binding: FragmentTrsfermetodeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTrsfermetodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnContinue1.setOnClickListener {
                findNavController().navigate(R.id.action_trsfermetodeFragment_to_trasfermetode1Fragment)
            }

            btnBack2.setOnClickListener {
                findNavController().navigate(R.id.action_trsfermetodeFragment_to_trasferfisrtFragment)
            }


        }
    }
}