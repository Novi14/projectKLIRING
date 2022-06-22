package com.example.homekliring.ui.Auth.Authentication.login


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.example.homekliring.R
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.homekliring.Data.retrofit.RetrofitBuilder
import com.example.homekliring.MainActivity
import com.example.homekliring.databinding.FragmentLoginBinding
import com.example.homekliring.ui.Auth.Authentication.register.RegisterFragment

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LoginViewModel
    private val emailValid = RegisterFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]

        loginRequirementCheck()

        with(binding) {
            tvSigUp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment2)
            }
            tvForget.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment2)
            }
            btnLogin.setOnClickListener{
                loginRequest()
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loginRequirementCheck() {
        with(binding) {
            tietLogEmail.doAfterTextChanged {
                val getEmail = tietLogEmail.text.toString() //getting email
                if (getEmail.isEmpty() || !emailValid.isValidString(getEmail)){
                    //checking if email is empty or invalid email
                    tillemail.helperText = getString(R.string.req_email)
                    tietLogEmail.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_failed)
                    tietLogEmail.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.merah))
                } else {
                    tillemail.helperText = null
                    tietLogEmail.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_background)
                    tietLogEmail.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.abu))
                }
            }

            tietLogPassword.doAfterTextChanged {
                val getPassword = tietLogPassword.text.toString() //getting password
                if (getPassword.count() < 8) {
                    //checking if password is empty or less than 8
                    tillPassword.helperText = getString(R.string.req_password_up_to_8)
                    tietLogPassword.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_failed)
                    tietLogPassword.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.merah))
                } else {
                    tillPassword.helperText = null
                    tietLogPassword.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_background)
                    tietLogPassword.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.abu))
                }
            }
        }
    }

    private fun loginRequest() {
        with(binding) {
            val getEmail = tietLogEmail.text.toString() //getting email
            val getPassword = tietLogPassword.text.toString() //getting password

            if (getEmail.isEmpty() || !emailValid.isValidString(getEmail)){
                Toast.makeText(context, getString(R.string.req_true_email_and_password), Toast.LENGTH_SHORT).show()
                tvLogNotif.setBackgroundColor(ContextCompat
                    .getColor(requireContext(), R.color.merah))
                tvLogNotif.text = getString(R.string.req_true_email_and_password)
            } else if (getPassword.isEmpty() || getPassword.count() < 8) {
                Toast.makeText(context, getString(R.string.req_password_up_to_8), Toast.LENGTH_SHORT).show()
                tvLogNotif.setBackgroundColor(ContextCompat
                    .getColor(requireContext(), R.color.merah))
                tvLogNotif.text = getString(R.string.req_password_up_to_8)
            } else if (getPassword.isNotEmpty() && getPassword.count() > 7) postData()
        }
    }

    private fun postData() {
        val loadingDialog = LoadingDialog(requireActivity()) //loadingDialog
        loadingDialog.startLoading()
        with(binding) {
            viewModel.loginUser(
                RetrofitBuilder.getRetrofit(this@LoginFragment.requireActivity().applicationContext),
                tietLogEmail.text.toString(),
                tietLogPassword.text.toString()
            ).observe(requireActivity()) {
                if (it.token.isBlank()) {
                    loadingDialog.isDismiss()
                    if (it.token.equals("401")) {
                        Toast.makeText(
                            context, getString(R.string.login_unauthorized),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            getString(R.string.login_failure),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    val sharedPref =
                        requireActivity().getSharedPreferences(
                            "allData",
                            Context.MODE_PRIVATE
                        )
                    val editor = sharedPref.edit()
                    editor.putString("email", tietLogEmail.text.toString())
                    editor.putString("password", tietLogPassword.text.toString())
                    editor.apply()

                    loadingDialog.isDismiss()
                    loginFinished()
                    registerFinished()

                    if (verificationFinished()) {
                        activity?.startActivity(Intent(activity, MainActivity::class.java))
                        activity?.finish()
                    } else findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment2)
                }
            }
        }
    }

    private fun loginFinished() {
        val sharedPref = requireActivity().getSharedPreferences(
            "login",
            Context.MODE_PRIVATE
        )
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

    private fun registerFinished() {
        val sharedPref = requireActivity().getSharedPreferences(
            "register",
            Context.MODE_PRIVATE
        )
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

    private fun verificationFinished(): Boolean {
        val sharedPref = requireActivity().getSharedPreferences("verified", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}