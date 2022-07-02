package com.example.homekliring.ui.Auth.Authentication.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.homekliring.Data.Api.ApiService
import com.example.homekliring.Data.Response.registerResponse
import com.example.homekliring.entity.RegisterEntity
import com.example.homekliring.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class RegisterViewModel (
    private val apiService: ApiService
) : ViewModel() {

    fun registerUser(
        email: String,
        password:String,
        nama_lengkap:String
    ): LiveData<Resource<RegisterEntity>> {
        val result = MutableLiveData<Resource<RegisterEntity>>()
        result.value = Resource.Loading(null)

        try {
            val param = mutableMapOf<String, String>()
            param["nama_lengkap"] = nama_lengkap
            param["password"] = password
            param["email"] = email

            apiService.registerUser(param).enqueue(object : Callback<registerResponse> {
                override fun onResponse(
                    call: Call<registerResponse>,
                    response: Response<registerResponse>
                ) {

                    val responseResult = response.body()

                    if (response.isSuccessful) {
                        result.value = Resource.Success(
                            RegisterEntity(
                                responseResult?.data?.namaLengkap?:"",
                                responseResult?.data?.email?:"",
                                responseResult?.data ?. id?:"",
                                responseResult?.data?.role ?:""
                            )
                        )
                    } else {
                        result.value = Resource.Error(response.code(), response.message(), null)
                    }

                }

                override fun onFailure(call: Call<registerResponse>, t: Throwable) {
                    when (t) {
                        is HttpException -> {
                            result.value = Resource.Error(t.code(), t.message() ?: "", null)
                        }
                    }
                }

            })

        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("REGISTER", "Register User: ${e.message}", e)
        }
        return result
    }

}


