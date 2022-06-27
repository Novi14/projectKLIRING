package com.example.homekliring.ui.Auth.Authentication.login


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homekliring.Data.Api.ApiService
import com.example.homekliring.Data.entity.loginEntity
import com.example.homekliring.Data.Response.loginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel : ViewModel() {

    fun loginUser(
        apiService: ApiService,
        email: String,
        password: String
    ): LiveData<loginEntity> {
        val result = MutableLiveData<loginEntity>()

        apiService.loginUser(email, password).enqueue(object : Callback<loginResponse> {
            override fun onResponse(
                call: Call<loginResponse>,
                response: Response<loginResponse>
            ) {
                val responseResult = response.body()

                if(response.isSuccessful) {
                    result.value = loginEntity (
                        responseResult?.status ?:0,
                        responseResult?.message ?:"",
                        responseResult?.accessToken ?:"",
                        responseResult?.refreshToken ?:""
                    )
                } else {
                    result.value = loginEntity(
                        0, "", "", ""
                    )
                }
            }

            override fun onFailure(call: Call<loginResponse>, t: Throwable) {
                Log.e("Login", "onFailure: ${t.message}", t)
            }
        })
        return result
    }

    companion object {
        const val FAILED_MESSAGE = "Login Failed"
    }

}
