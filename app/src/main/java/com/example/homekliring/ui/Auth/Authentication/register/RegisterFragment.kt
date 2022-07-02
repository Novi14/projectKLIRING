package com.example.homekliring.ui.Auth.Authentication.register


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.fragment.findNavController
import com.example.homekliring.DataStore.PREFERENCE_NAME
import com.example.homekliring.databinding.FragmentRegisterBinding
import com.example.homekliring.R
import com.example.homekliring.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

val Context.dataStore by preferencesDataStore(name = PREFERENCE_NAME)

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<RegisterViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnGetstarted.setOnClickListener {
                pbLoading.visibility = View.VISIBLE

                if(validateInput()){
                    viewModel.registerUser(
                        tfEmail.text.toString(),tfPassword.text.toString(),tfFistname.text.toString()
                    ).observe(requireActivity()) {
                        when (it) {
                            is Resource.Loading -> {
                                pbLoading.visibility = View.VISIBLE
                            }
                            is Resource.Success -> {
                                findNavController().navigate(R.id.action_registerFragment_to_email_verifikasiFragment)

                                pbLoading.visibility = View.GONE
                            }
                            is Resource.Error -> {
                                pbLoading.visibility = View.VISIBLE

                                when (it.statusCode) {
                                    401 -> {
                                        Toast.makeText(
                                            requireContext(),
                                            "Silahkan coba daftar kembali",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    404 -> {
                                        binding.tillPassword2.error = "Password anda salah"
                                    }
                                    101 -> {
                                        Toast.makeText(
                                            requireContext(),
                                            "Tidak ada koneksi internet",
                                            Toast.LENGTH_SHORT
                                        )
                                            .show()

                                    }
                                    102 -> {
                                        Toast.makeText(
                                            requireContext(),
                                            "Mohon periksa jaringan anda",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                                pbLoading.visibility = View.GONE
                            }
                        }
                    }
                }
            }

            btnBack1.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_startFragment)
            }

            tvLogIn.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun validateInput(): Boolean {
        with(binding) {
            return if (tfFistname.text?.isEmpty() == true && tfEmail.text?.isEmpty() == true && tfPassword.text?.isEmpty() == null) {
                Toast.makeText(
                    requireContext(),
                    "Input tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
                false
            } else true
        }
    }

}

