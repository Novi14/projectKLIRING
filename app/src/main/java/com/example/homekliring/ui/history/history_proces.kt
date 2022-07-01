package com.example.homekliring.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentHistoryonprocess1Binding

class history_proces : Fragment() {
    private var _binding: FragmentHistoryonprocess1Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        _binding = FragmentHistoryonprocess1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        return root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnBackTransaksi.setOnClickListener {
                findNavController().navigate(R.id.action_history_proces_to_historydone)
            }

            btnApply2.setOnClickListener {
                findNavController().navigate(R.id.action_history_proces_to_trasfertokliringFragment)
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
