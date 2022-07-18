package com.home.kliring.ui.Auth.Authentication.forgotpassword

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Patterns
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import  com.home.kliring.databinding.FragmentForgotPassword2Binding
import  com.home.kliring.R

class ForgotPasswordFragment : Fragment() {
    private var _binding: FragmentForgotPassword2Binding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ForgetPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[ForgetPasswordViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentForgotPassword2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            btnBack10.setOnClickListener {
                findNavController().popBackStack()
            }

            btnSand.setOnClickListener {
                val email = etEmail.text.toString().trim()

                if (isValidEntry(email)) {
                    hideSoftKeyboard()

                    //Navigate to ForgetPasswordConfirmationFragment
                    findNavController().navigate(R.id.action_forgotPasswordFragment2_to_riset_passwordFragment2)
                }

                tvLogIn.setOnClickListener {
                    findNavController().navigate(R.id.action_forgotPasswordFragment2_to_loginFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    //Check and validate user input
    private fun isValidEntry(email: String): Boolean {
        with(binding) {
            tvEror.visibility = View.GONE

            if (email.isEmpty()) {
                hideSoftKeyboard()

                tvEror.visibility = View.VISIBLE
                tvEror.text = getString(R.string.text_error_empty_email)
                etEmail.requestFocus()

                return false
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                hideSoftKeyboard()

                tvEror.visibility = View.VISIBLE
                tvEror.text = getString(R.string.text_error_email_format_not_valid)
                etEmail.requestFocus()

                return false
            }

            return true
        }
    }

    //For hide keyboard while edittext not in focus
    private fun hideSoftKeyboard() {
        if (activity?.currentFocus != null && activity?.currentFocus is EditText) {
            val imm: InputMethodManager? =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(binding.etEmail.windowToken, 0)
        }
    }

}
