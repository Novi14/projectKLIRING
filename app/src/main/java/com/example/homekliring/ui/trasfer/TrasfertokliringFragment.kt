package com.example.homekliring.ui.trasfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentTrasfertokliringBinding

class TrasfertokliringFragment : Fragment() {

    private var _binding: FragmentTrasfertokliringBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTrasfertokliringBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnReady.setOnClickListener {
                findNavController().navigate(R.id.action_trasfertokliringFragment_to_trasferfisrtFragment)
            }
            btnUplod.setOnClickListener {
                findNavController().navigate(R.id.action_trasfertokliringFragment_to_uploadbuktitrasferFragment)
            }


        }
    }
}