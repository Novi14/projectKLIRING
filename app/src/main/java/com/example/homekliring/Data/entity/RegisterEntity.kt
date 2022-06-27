package com.example.homekliring.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@kotlinx.android.parcel.Parcelize
data class RegisterEntity(
    val email: String,
    val id: String,
    val role: String


): Parcelable