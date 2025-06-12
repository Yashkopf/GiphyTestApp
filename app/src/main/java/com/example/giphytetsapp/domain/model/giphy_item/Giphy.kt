package com.example.giphytetsapp.domain.model.giphy_item


import com.google.gson.annotations.SerializedName

data class Giphy(
    val `data`: Data?,
    val meta: Meta?
)