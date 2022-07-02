package com.example.homekliring.ui.Auth.Authentication.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.fragment.findNavController
import com.example.homekliring.R
import com.example.homekliring.DataStore.PREFERENCE_NAME
import com.example.homekliring.MainActivity
import com.example.homekliring.databinding.FragmentLoginBinding
import com.example.homekliring.utils.Resource
import org.koin.androidx.viewmodel.ext.android.viewModel

val Context.dataStore by preferencesDataStore(name = PREFERENCE_NAME)

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvSigUp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment2)
            }
            tvForget.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment2)
            }


            btnLogin.setOnClickListener {

                if (validateInput()) {
                    viewModel.loginUser(
                        tietLogEmail.text.toString(),
                        tietLogPassword.text.toString()
                    ).observe(requireActivity()) {
                        when (it) {
                            is Resource.Loading -> {
                                pbLoading.visibility = View.VISIBLE
                            }
                            is Resource.Success -> {
                                pbLoading.visibility = View.GONE
                                val sharedPref = requireActivity().getSharedPreferences("userData", Context.MODE_PRIVATE)
                                val editor = sharedPref.edit()
                                editor.putString("token", it.data?.accessToken)
                                editor.apply()

                                val intent = Intent(requireActivity(), MainActivity::class.java)
                                startActivity(intent)

                                loginFinished()

                                requireActivity().finish()
                            }
                            is Resource.Error -> {
                                pbLoading.visibility = View.VISIBLE

                                when (it.statusCode) {
                                    401 -> {
                                        Toast.makeText(
                                            requireContext(),
                                            "Silahkan login kembali",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    404 -> {
                                        binding.tillPassword.error = "Password anda salah"
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
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun validateInput(): Boolean {
        with(binding) {
            return when {
                tietLogEmail.text?.trim().isNullOrEmpty() -> {
                    tillemail.error = "Email tidak boleh kosong"
                    false
                }
                (tietLogPassword.text?.length ?: 0) < 8 -> {
                    tillPassword.error = "Password minimal 8 karakter"
                    false
                }
                else -> {
                    tillemail.error = null
                    tillPassword.error = null
                    true
                }
            }

        }
    }

    private fun loginFinished() {
        val sharedPref = requireActivity().getSharedPreferences("Login", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}
