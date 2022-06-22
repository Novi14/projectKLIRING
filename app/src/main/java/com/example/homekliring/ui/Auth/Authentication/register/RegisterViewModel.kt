package com.example.homekliring.ui.Auth.Authentication.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.homekliring.Data.api.ApiService
import com.example.homekliring.Data.response.RegisterResponse
import com.example.homekliring.entity.RegisterEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    fun registerUser(
        apiService: ApiService,
        name: String,
        email: String,
        password: String
    ): LiveData<RegisterEntity> {
        val result = MutableLiveData<RegisterEntity>()

        try {
            val param = mutableMapOf<String, String>()
            param["name"] = name
            param["email"] = email
            param["password"] = password

            apiService.registerUser(param).enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseResult = response.body()

                        result.value = RegisterEntity(
                            responseResult?.namaUser ?: "",
                            responseResult?.email?: "",
                            responseResult?.password?: "",
                            responseResult?.id ?: 0
                        )
                    } else {
                        result.value = RegisterEntity(
                            response.code().toString(),
                            "",
                            "",
                            0

                        )
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    result.value = RegisterEntity(
                        t.message.toString(),
                        "",
                        "",
                        0

                    )
                    Log.e("Registrasi ", " gagal, ${t.message}", t)
                }

            })
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("REGISTER", "Register User: ${e.message}", e)
        }
        return result
    }
}
