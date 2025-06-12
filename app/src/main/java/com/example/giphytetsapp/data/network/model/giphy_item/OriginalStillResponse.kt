package com.example.giphytetsapp.data.network.model.giphy_item


import com.google.gson.annotations.SerializedName

data class OriginalStillResponse(
    @SerializedName("height")
    val height: String?,
    @SerializedName("size")
    val size: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: String?
)