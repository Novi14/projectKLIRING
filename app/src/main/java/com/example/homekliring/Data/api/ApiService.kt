package com.example.homekliring.Data.api

import com.example.homekliring.Data.response.LoginResponse
import com.example.homekliring.Data.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
interface ApiService {

    //Untuk login
    @FormUrlEncoded
    @POST("auth/login")
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    //Untuk Register
    @POST("user/register")
    fun registerUser(
        @Body param: Map<String, String>
    ): Call<RegisterResponse>




}