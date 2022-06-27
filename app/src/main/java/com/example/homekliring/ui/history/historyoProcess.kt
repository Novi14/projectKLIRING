package com.example.homekliring.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentHistorionprosesBinding

class historyoProcess  : Fragment() {
    private var _binding: FragmentHistorionprosesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        _binding =FragmentHistorionprosesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            tvSee.setOnClickListener {
                findNavController().navigate(R.id.action_historionproses_to_historydone)
            }

            tvOn.setOnClickListener {
                findNavController().navigate(R.id.action_historionproses_to_historionproces)
            }

            btnBack8.setOnClickListener {
                findNavController().navigate(R.id.action_historydone_to_historionproses)
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
