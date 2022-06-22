package com.example.homekliring.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentTrasferBinding
import com.example.homekliring.ui.trasfer.trasferViewModel


class TrasferFragment : Fragment() {
    private var _binding: FragmentTrasferBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val trasferViewModel =
            ViewModelProvider(this).get(trasferViewModel::class.java)

        _binding = FragmentTrasferBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            btnChoose.setOnClickListener {
                findNavController().navigate(R.id.action_navigasi_trasfer_to_trasferfisrtFragment)
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}