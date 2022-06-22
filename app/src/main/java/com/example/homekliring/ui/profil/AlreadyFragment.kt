package com.example.homekliring.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.homekliring.databinding.FragmentAlreadyBinding
import com.example.homekliring.databinding.FragmentHelp2Binding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AlreadyFragment (
    private val title: String,
    private val okAction: () -> Unit

): DialogFragment() {
    private var _binding: FragmentHelp2Binding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelp2Binding.inflate(inflater, container, false)


        return  binding . root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){

        }
    }


}