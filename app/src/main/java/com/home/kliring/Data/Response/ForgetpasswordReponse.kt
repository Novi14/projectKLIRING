package com.home.kliring.Data.Response

import com.google.gson.annotations.SerializedName

data class ForgetpasswordReponse(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("statusCode")
    val statusCode: Int? = null
)
