package com.example.homekliring.ui.Auth.Authentication.login


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homekliring.Data.api.ApiService
import com.example.homekliring.Data.entity.LoginEntity
import com.example.homekliring.Data.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel : ViewModel() {

    fun loginUser(
        apiService: ApiService,
        email: String,
        password: String
    ): LiveData<LoginEntity> {
        val result = MutableLiveData<LoginEntity>()

        try {
            apiService.loginUser(email, password).enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseResult = response.body()

                        result.value = LoginEntity(
                            responseResult?.token?: "",
                            responseResult?.id?:0,
                            responseResult?.namaUser?:"",
                            responseResult?.email?:""

                        )
                    } else {
                        result.value = LoginEntity(
                            response.code().toString(),
                            response.code().toInt(),
                            response.code().toString(),
                            response.code().toString()


                        )
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    result.value = LoginEntity(
                        "",0,"",""

                    )
                    Log.e("Login ", " gagal, ${t.message}", t)
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("LOGIN", "Login User: ${e.message}", e)
        }
        return result
    }
}