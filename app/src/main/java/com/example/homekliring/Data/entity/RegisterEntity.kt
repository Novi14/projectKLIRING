package com.example.homekliring.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class RegisterEntity(
    val nama_lengkap:String,
    val email: String,
    val id: String,
    val role: String


): Parcelable