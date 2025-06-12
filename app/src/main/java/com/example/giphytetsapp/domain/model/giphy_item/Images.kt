package com.example.giphytetsapp.domain.model.giphy_item


import com.google.gson.annotations.SerializedName

data class Images(
    val original: Original?,
    val originalMp4: OriginalMp4?,
    val originalStill: OriginalStill?,
)