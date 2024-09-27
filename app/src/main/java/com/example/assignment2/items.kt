package com.example.assignment2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class items(val nameval : String,
                 val credit: Float, val rate: Float,
                 val multi:List<String>, val imgid: Int, var available:Boolean): Parcelable {
}