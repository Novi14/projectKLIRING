package com.home.kliring.ui.Auth.Authentication.forgotpassword

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.home.kliring.Data.entity.forgetpasswordEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "ForgetPasswordViewModel"

class ForgetPasswordViewModel : ViewModel() {
    companion object {
        const val SUCCEED_MESSAGE = "Forget Password Success"
        const val FAILED_MESSAGE = "Forget Password Failed"
        const val CONNECTION_FAILED_MESSAGE = "Connection Failed"
    }

    fun forgetPassword(
        apiService: com.home.kliring.Data.Api.ApiService,
        email: String
    ): LiveData<forgetpasswordEntity> {
        val result = MutableLiveData<forgetpasswordEntity>()

        apiService.forgetPassword(email).enqueue(object: Callback< com.home.kliring.Data.Response.ForgetpasswordReponse> {
            override fun onResponse(
                call: Call< com.home.kliring.Data.Response.ForgetpasswordReponse>,
                response: Response< com.home.kliring.Data.Response.ForgetpasswordReponse>
            ) {
                val responseResult = response.body()

                if (response.isSuccessful) {
                    result.value = forgetpasswordEntity(
                        responseResult?.statusCode ?: 200,
                        responseResult?.message ?: SUCCEED_MESSAGE
                    )
                } else {
                    result.value = forgetpasswordEntity(
                        responseResult?.statusCode ?: 400,
                        responseResult?.message ?: FAILED_MESSAGE
                    )
                }
            }

            override fun onFailure(call: Call< com.home.kliring.Data.Response.ForgetpasswordReponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}", )
                result.value = forgetpasswordEntity(
                    400,
                    CONNECTION_FAILED_MESSAGE
                )
            }

        })

        return result
    }
}