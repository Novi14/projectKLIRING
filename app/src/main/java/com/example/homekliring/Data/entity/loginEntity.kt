package com.example.homekliring.Data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class loginEntity (
    val status: Int,
    val message: String,
    val accessToken: String,
    val refreshToken: String
):Parcelable
