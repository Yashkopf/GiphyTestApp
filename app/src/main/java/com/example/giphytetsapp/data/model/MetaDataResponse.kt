package com.example.giphytetsapp.data.model

import com.google.gson.annotations.SerializedName

data class MetaDataResponse (
    @SerializedName("msg")
    val msg: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("response_id")
    val responseId: String
)