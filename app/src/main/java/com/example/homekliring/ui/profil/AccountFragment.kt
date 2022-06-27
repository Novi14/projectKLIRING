package com.example.homekliring.ui.profil


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentAccountBinding


class AccountFragment : DialogFragment() {

    private val binding: FragmentAccountBinding by viewBinding()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireDialog().window?.setBackgroundDrawableResource(android.R.color.transparent)
        isCancelable = false
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvCancel.setOnClickListener {
                findNavController().navigate(R.id.action_accountFragment_to_navigasi_profil)
            }

            tvLogOut2.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_help_to_notifikasi_besrhasillogout)
            }
        }

    }

}