package com.example.homekliring.ui.Auth.Authentication.login


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homekliring.Data.Api.ApiService
import com.example.homekliring.Data.entity.loginEntity
import com.example.homekliring.Data.Response.loginResponse
import com.example.homekliring.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
class LoginViewModel(
    private val apiService: ApiService
) : ViewModel(){

    fun loginUser(
        email: String,
        password: String
    ): LiveData<Resource<loginEntity>> {
        val result = MutableLiveData<Resource<loginEntity>>()

        result.value = Resource.Loading(null)

        apiService.loginUser(email, password).enqueue(object : Callback<loginResponse> {
            override  fun onResponse(call: Call<loginResponse>, response: Response<loginResponse>) {
                val responseResult = response.body()

                if (response.isSuccessful) {
                    result.value = Resource.Success(
                        loginEntity(
                            responseResult?.status ?: 0,
                            responseResult?.message ?: "",
                            responseResult?.accessToken ?: "",
                            responseResult?.refreshToken ?: ""
                        )
                    )
                } else {
                    result.value = Resource.Error(response.code(), response.message(), null)
                }
            }

            override fun onFailure(call: Call<loginResponse>, t: Throwable) {
                when(t) {
                    is HttpException -> {
                        result.value = Resource.Error(t.code(), t.message ?: "", null)
                    }
                }
            }
        })
        return result
    }

}