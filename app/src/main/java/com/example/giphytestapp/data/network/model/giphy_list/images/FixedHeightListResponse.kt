package com.example.giphytestapp.data.network.model.giphy_list.images


import com.google.gson.annotations.SerializedName

data class FixedHeightListResponse(
    @SerializedName("height")
    val height: String,
    @SerializedName("mp4")
    val mp4: String,
    @SerializedName("mp4_size")
    val mp4Size: String,
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