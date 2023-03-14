package com.example.bcasyariah.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsModel(
    val image:Int?,
    val title:String?,
    val subtitle:String?
):Parcelable
