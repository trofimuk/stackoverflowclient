package com.example.data.questions

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("display_name")
    val authorName: String? = null
)