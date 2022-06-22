package com.example.homekliring.ui.trasfer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homekliring.databinding.FragmentBuktitrasferBinding

class BuktiTrasfer  : Fragment() {

    private var _binding: FragmentBuktitrasferBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBuktitrasferBinding .inflate(inflater, container, false)
        return binding.root
    }


}


