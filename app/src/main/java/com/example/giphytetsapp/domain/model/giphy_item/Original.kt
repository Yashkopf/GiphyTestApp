package com.example.giphytetsapp.domain.model.giphy_item


import com.google.gson.annotations.SerializedName

data class Original(
    val frames: String?,
    val hash: String?,
    val height: String?,
    val mp4: String?,
    val mp4Size: String?,
    val size: String?,
    val url: String?,
    val webp: String?,
    val webpSize: String?,
    val width: String?
)