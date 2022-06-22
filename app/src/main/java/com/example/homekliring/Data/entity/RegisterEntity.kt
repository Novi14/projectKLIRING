package com.example.homekliring.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@kotlinx.android.parcel.Parcelize
data class RegisterEntity(

    val client_name: String,
    val client_email: String,
    val client_password: String,
    val client_id: Int


): Parcelable