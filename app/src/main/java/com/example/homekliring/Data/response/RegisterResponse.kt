package com.example.homekliring.Data.response
import com.google.gson.annotations.SerializedName
data class RegisterResponse(

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("update_at")
    val updateAt: String? = null,

    @field:SerializedName("nama_user")
    val namaUser: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("create_at")
    val createAt: String? = null,

    @field:SerializedName("email")
    val email: String? = null
)

