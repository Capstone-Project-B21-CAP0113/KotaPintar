package com.capstone.myapplication.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class dataSturcture(
    val id: String,
    val photo:String,
    val title: String,
    val detail: String,
    val username: String,
    val email: String,
    val status: String,
    val location: String,
    val timeEvent: String,
    val timePublish:String,
    val favorite: String


) : Parcelable