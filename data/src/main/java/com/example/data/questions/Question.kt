package com.example.data.questions

import com.google.gson.annotations.SerializedName

data class Question(
    val question_id: Long,

    val title: String? = null,

    val owner: Owner? = null,

    @SerializedName("creation_date")
    val date: String? = null
)