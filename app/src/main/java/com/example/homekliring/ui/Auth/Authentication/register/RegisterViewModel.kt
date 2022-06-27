package com.example.homekliring.ui.Auth.Authentication.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.homekliring.Data.Api.ApiService
import com.example.homekliring.Data.Response.registerResponse
import com.example.homekliring.entity.RegisterEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel  : ViewModel() {
    fun registerUser(
        apiService: ApiService,
         email: String
        ): LiveData<RegisterEntity>{
        val  result = MutableLiveData<RegisterEntity>()

        val param = mutableMapOf<String, String>()
               param["email"] = email

        apiService.registerUser(param).enqueue(object : Callback<registerResponse> {
            override fun onResponse(
                call: Call<registerResponse>,
                response: Response<registerResponse>
            ) {

                val responseResult = response.body()
                Log.e("tag", "onResponse: $responseResult")

                if (response.isSuccessful) {
                    result.value = RegisterEntity(
                        responseResult?.data?.email?:"",
                        responseResult?.data ?. id?:"",
                        responseResult?.data?.role ?:""


                    )
                } else {
                    result.value = RegisterEntity(
                        "",
                        "",
                        ""
                    )
                }
            }

            override fun onFailure(call: Call<registerResponse>, t: Throwable) {
                Log.e("Register customer", "onFailure: ${t.message}", t)
            }
        })

        return result
    }
}