package com.userfaltakas.mynavigationdemo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Movie(
    val title: String,
    val rate: Int
) : Parcelable
