package com.example.homekliring.ui.trasfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.activity.result.ActivityResultCallback
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentUploudbuktiBinding

class UplodbuktiFragment : Fragment() {

    private var _binding: FragmentUploudbuktiBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUploudbuktiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnDone.setOnClickListener {
                findNavController().navigate(R.id.action_uploadbuktiFragment_to_trasaksiberhasil)
            }


        }
    }
}