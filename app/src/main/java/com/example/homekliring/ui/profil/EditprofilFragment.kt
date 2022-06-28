package com.example.homekliring.ui.profil


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.databinding.FragmentEditprofilBinding

class EditprofilFragment : Fragment() {

    private var _binding: FragmentEditprofilBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEditprofilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
          with(binding){
            btnSave.setOnClickListener {
                findNavController().navigate(R.id.action_editprofil_to_profilFragment)
            }
              tvChange.setOnClickListener {
                  findNavController().navigate(R.id.action_edit_profil_to_uplodprofil2)
              }

              btnBack13.setOnClickListener {
                  findNavController().navigate(R.id.action_edit_profil_to_navigasi_profil)
              }



        }
    }


}