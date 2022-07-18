package com.home.kliring.Data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class forgetpasswordEntity(
    val statusCode: Int,
    val message: String
): Parcelable