package com.example.homekliring.Data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("token")
	val token: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("nama_user")
	val namaUser: String? = null,

	@field:SerializedName("email")
	val email: String? = null


)
