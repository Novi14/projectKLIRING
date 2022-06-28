package com.example.homekliring.Data.Api

import com.example.homekliring.Data.Response.loginResponse
import com.example.homekliring.Data.Response.registerResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
interface ApiService {

    //Untuk login
    @FormUrlEncoded
    @POST("/auth/login/pengguna")
    fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<loginResponse>

    //Untuk Register
        @POST("/users/register/pengguna")
    fun registerUser(
        @Body param: Map<String, String>
    ): Call<registerResponse>




}