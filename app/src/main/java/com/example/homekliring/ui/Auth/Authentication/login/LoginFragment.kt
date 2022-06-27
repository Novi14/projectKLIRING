package com.example.homekliring.ui.Auth.Authentication.login


import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.homekliring.R
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.homekliring.Data.retrofit.RetrofitBuilder
import com.example.homekliring.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel:LoginViewModel

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

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        with(binding) {
            tvSigUp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment2)
            }
            tvForget.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment2)
            }

            btnLogin.setOnClickListener {
                pbLoading.visibility = View.VISIBLE

                if (validateInput()) {
                    viewModel.loginUser(
                        RetrofitBuilder.getRetrofit(this@LoginFragment.requireActivity().applicationContext),
                        tietLogEmail.text.toString(),
                        tietLogPassword.text.toString()
                    ).observe(requireActivity()) {
                        pbLoading.visibility = View.GONE

                        if (it.accessToken.isNullOrEmpty()) {
                            Toast.makeText(
                                requireActivity(),
                                "Failed To Login",
                                Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(
                                requireActivity(),
                                "Login Success",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun validateInput(): Boolean {
        with(binding) {
            return if (tietLogEmail.text?.isEmpty() == true || tietLogPassword.text?.isEmpty() == true) {
                pbLoading.visibility = View.GONE

                if (tietLogEmail.text?.isEmpty() == true) {
                    tillemail.error = "Input tidak boleh kosong"
                }
                if (tietLogPassword.text?.isEmpty() == true) {
                    tillPassword.error = "Input tidak boleh kosong"
                }

                Toast.makeText(requireActivity(), "Input tidak boleh Kosong", Toast.LENGTH_SHORT).show()
                false
            } else true
        }
    }

}

