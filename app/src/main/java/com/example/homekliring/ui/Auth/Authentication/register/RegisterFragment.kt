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
import com.example.homekliring.ui.Auth.Authentication.login.LoadingDialog

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: RegisterViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[RegisterViewModel::class.java]

        registerRequirementCheck()

        with(binding) {
            tvLogIn.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }

            btnGetstarted.setOnClickListener{
                registerRequest()
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun registerRequirementCheck() {
        with(binding) {
            tfFistname.doAfterTextChanged {
                val getFullname = tfFistname.text.toString() //getting full name
                if (getFullname.isEmpty() || getFullname.count() < 3) {
                    //checking if full name is empty or less than 3 char
                    tillFistname.helperText = getString(R.string.req_fullname)
                    tfFistname.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_failed)
                    tfFistname.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.merah))
                } else {
                    tillFistname.helperText = null
                    tfFistname.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_background)
                    tfFistname.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.abu))
                }
            }

            tfEmail.doAfterTextChanged {
                val getEmail = tfEmail.text.toString() //getting email
                if (getEmail.isEmpty() || !isValidString(getEmail)){
                    //checking if email is empty or invalid email
                    tillEmail.helperText = getString(R.string.req_email)
                    tfEmail.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_failed)
                    tfEmail.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.merah))
                } else {
                    tillEmail.helperText = null
                    tfEmail.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_background)
                    tfEmail.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.abu))
                }
            }

            tfPassword.doAfterTextChanged {
                val getPassword = tfPassword.text.toString() //getting password
                if (getPassword.count() < 8) {
                    //checking if password is empty or less than 8
                    tillPassword2.helperText = getString(R.string.req_password_up_to_8)
                    tfPassword.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_failed)
                    tfPassword.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.merah))
                } else {
                    tillPassword2.helperText = null
                    tfPassword.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_background)
                    tfPassword.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.abu))
                }
            }

            tfRepertpassword.doAfterTextChanged {
                val getPassword = tfRepertpassword.text.toString() //getting password
                val getRepeatPassword = tfRepertpassword.text.toString() //getting repeat password
                if (getRepeatPassword.count() < 8) {
                    //checking if repeat password is'n same
                    tillUlangiPassword.helperText = getString(R.string.req_password_up_to_8)
                    tfRepertpassword.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_failed)
                    tfRepertpassword.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.merah))
                } else if (getRepeatPassword != getPassword) {
                    tillUlangiPassword.helperText = getString(R.string.req_password_same)
                    tfRepertpassword.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_failed)
                    tfRepertpassword.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.merah))
                } else {
                    tillUlangiPassword.helperText = null
                    tfRepertpassword.background = ContextCompat
                        .getDrawable(requireContext() ,R.drawable.stroke_background)
                    tfRepertpassword.setHintTextColor(ContextCompat
                        .getColor(requireContext() ,R.color.abu))
                }
            }
        }
    }

    private fun registerRequest() {
        with(binding) {
            val getFullname = tfFistname.text.toString() //getting full name
            val getEmail = tfEmail.text.toString() //getting email
            val getPassword = tfPassword.text.toString() //getting password
            val getRepeatPassword = tfRepertpassword.text.toString() //getting repeat password


            if (getFullname.isEmpty() || getFullname.count() < 3) {
                //checking if full name is empty or less than 3 char
                Toast.makeText(context, getString(R.string.req_fullname),
                    Toast.LENGTH_SHORT).show()


            } else if (getEmail.isEmpty() || !isValidString(getEmail)) {
                //checking if email is empty or invalid email
                Toast.makeText(context, getString(R.string.req_email),
                    Toast.LENGTH_SHORT).show()

            }else if (getPassword.count() < 8) {
                //checking if password is empty or less than 8
                Toast.makeText(context, getString(R.string.req_password_up_to_8),
                    Toast.LENGTH_SHORT).show()

            } else  if (getRepeatPassword != getPassword) {
                //checking if repeat password is correct or not
                Toast.makeText(context, getString(R.string.req_password_same),
                    Toast.LENGTH_SHORT).show()

            } else if (getPassword.count() > 7 && getRepeatPassword == getPassword)
                postData(getFullname, getEmail, getPassword)
        }
    }

    fun isValidString(str: String): Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
    }

    private fun postData(
        fullname : String,
        email : String,
        password : String
    ) {
        val loadingDialog = LoadingDialog(requireActivity()) //loadingDialog
        loadingDialog.startLoading()
        with (binding) {
            viewModel.registerUser(
                RetrofitBuilder.getRetrofit(this@RegisterFragment.requireActivity().applicationContext),
                fullname,
                email,
                password
            ).observe(requireActivity()) {
                if (it.client_name.isBlank()) {
                    loadingDialog.isDismiss()
                    if (it.client_name.equals("409")) {
                        Toast.makeText(context,
                            getString(R.string.registration_conflict),
                            Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context,
                            getString(R.string.registration_failure) + it.client_name,
                            Toast.LENGTH_SHORT).show()
                        loadingDialog.isDismiss()
                    }
                } else {
                    val sharedPref = requireActivity().getSharedPreferences("allData", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putString("fullname", fullname)
                    editor.putString("email", email)
                    editor.putString("password", password)
                    editor.apply()

                    loadingDialog.isDismiss()
                    registerFinished()
                    loginFinished()
                    findNavController().navigate(R.id.action_registerFragment_to_email_verifikasiFragment)
                }
            }
        }
    }

    private fun registerFinished() {
        val sharedPref = requireActivity().getSharedPreferences(
            "register",
            Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
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

}