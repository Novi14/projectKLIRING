package com.example.homekliring.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.activity.result.ActivityResultCallback
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentUploudprofilBinding

class uploudprofilfragment : Fragment() {

    private var _binding: FragmentUploudprofilBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUploudprofilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            with(binding){
            button2.setOnClickListener {
                findNavController().navigate(R.id.action_uploudprofilFragment_to_alreadyFragment)
            }


        }
    }
}