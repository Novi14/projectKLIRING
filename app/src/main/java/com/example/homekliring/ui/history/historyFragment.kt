package com.example.homekliring.ui.history


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentHistorydoneBinding


class historyFragment : Fragment() {
    private var _binding: FragmentHistorydoneBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        _binding = FragmentHistorydoneBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            tvDone.setOnClickListener {
                findNavController().navigate(R.id.action_historydone_to_historionproses)
            }

            btnBack7.setOnClickListener {
                findNavController().navigate(R.id.action_historydone_to_navigation_home)
            }

            tvOnproces.setOnClickListener {
                findNavController().navigate(R.id.action_historydone_to_history_proces)
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
