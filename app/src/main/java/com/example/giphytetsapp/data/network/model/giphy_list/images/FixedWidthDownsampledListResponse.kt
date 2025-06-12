package com.example.giphytetsapp.data.network.model.giphy_list.images


import com.google.gson.annotations.SerializedName

data class FixedWidthDownsampledListResponse(
    @SerializedName("height")
    val height: String,
    @SerializedName("size")
    val size: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("webp")
    val webp: String,
    @SerializedName("webp_size")
    val webpSize: String,
    @SerializedName("width")
    val width: String
)