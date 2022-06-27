package com.example.homekliring.ui.Auth.Authentication.register


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.homekliring.Data.retrofit.RetrofitBuilder
import com.example.homekliring.databinding.FragmentRegisterBinding
import com.example.homekliring.R

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RegisterViewModel

    companion object {
        val EXTRA_EMAIL = "extra_email"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[RegisterViewModel::class.java]

        with(binding) {
            tvLogIn.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }

            btnGetstarted.setOnClickListener {
                pbLoading.visibility = View.VISIBLE

                if(validateInput()) {
                    viewModel.registerUser(
                        RetrofitBuilder.getRetrofit(this@RegisterFragment.requireActivity().applicationContext),
                        tfEmail.text.toString(),
                       ).observe(requireActivity()) {
                        pbLoading.visibility = View.GONE

                        if (it.id.isNullOrEmpty()) {
                            Toast.makeText(
                                requireActivity(),
                                "Failed to register",
                                Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(
                                requireActivity(),
                                "Success Register \n Your id : ${it.id}",
                                Toast.LENGTH_SHORT).show()

                            val mBundle = Bundle()
                            mBundle.putString(EXTRA_EMAIL, "${it.email}")

                            findNavController().navigate(R.id.action_registerFragment_to_email_verifikasiFragment, mBundle)
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
            return if (tfFistname.text?.isEmpty() == true || tfPassword.text?.isEmpty() == true || tfEmail.text?.isEmpty() == true) {
                pbLoading.visibility = View.GONE

                if (tfFistname.text?.isEmpty() == true) {
                    tillFistname.error = "Input tidak boleh kosong"
                }
                if (tfPassword.text?.isEmpty() == true) {
                    tillPassword2.error = "Input tidak boleh kosong"
                }
                if (tfEmail.text?.isEmpty() == true) {
                    tillEmail.error = "Input tidak boleh kosong"
                }

                Toast.makeText(
                    requireActivity(),
                    "Input tidak boleh Kosong",
                    Toast.LENGTH_SHORT
                ).show()
                false
            } else true

        }
    }

}

