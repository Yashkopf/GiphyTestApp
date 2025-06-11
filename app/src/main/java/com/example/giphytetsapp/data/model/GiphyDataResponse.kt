package com.example.giphytetsapp.data.model

import com.google.gson.annotations.SerializedName

data class GiphyDataResponse (
    @SerializedName("data")
    val data: List<GiphyItemResponse>
)