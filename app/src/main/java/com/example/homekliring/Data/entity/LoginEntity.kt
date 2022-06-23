package com.example.homekliring.Data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@kotlinx.parcelize.Parcelize
data class LoginEntity(
    val token: String,
    val id : Int,
    val namaUser : String,
    val email : String,
): Parcelable

