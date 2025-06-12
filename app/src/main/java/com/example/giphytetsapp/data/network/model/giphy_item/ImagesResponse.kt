package com.example.giphytetsapp.data.network.model.giphy_item


import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("original")
    val original: OriginalResponse?,
    @SerializedName("original_mp4")
    val originalMp4: OriginalMp4Response?,
    @SerializedName("original_still")
    val originalStill: OriginalStillResponse?,
)