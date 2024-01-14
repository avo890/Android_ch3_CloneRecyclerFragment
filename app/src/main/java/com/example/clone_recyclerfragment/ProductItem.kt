package com.example.clone_recyclerfragment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductItem
    (
    val product: Int,
    val price: String,
    val time: String,
    val title: String,
    val loca: String,
    val description: String
) : Parcelable
