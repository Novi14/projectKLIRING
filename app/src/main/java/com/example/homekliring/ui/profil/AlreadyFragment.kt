package com.example.homekliring.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.homekliring.databinding.FragmentAlreadyBinding

class AlreadyFragment : DialogFragment() {

    private val binding: FragmentAlreadyBinding by viewBinding2()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireDialog().window?.setBackgroundDrawableResource(android.R.color.transparent)
        isCancelable = false
        return binding.root
    }
}