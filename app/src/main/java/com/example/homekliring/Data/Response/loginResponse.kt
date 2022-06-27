package com.example.homekliring.Data.Response

import com.google.gson.annotations.SerializedName


data class loginResponse (
	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("access_token")
	val accessToken: String? = null,

	@field:SerializedName("refresh_token")
	val refreshToken: String? = null
)

