package com.example.bcasyariah.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodModel(
    val image: String?,
    val title: String,
    val subtitle: String?,
    val category: String
) : Parcelable