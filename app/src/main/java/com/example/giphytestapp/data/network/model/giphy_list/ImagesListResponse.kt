package com.example.giphytestapp.data.network.model.giphy_list


import com.example.giphytestapp.data.network.model.giphy_list.images.FixedHeightListResponse
import com.example.giphytestapp.data.network.model.giphy_list.images.FixedWidthListResponse
import com.google.gson.annotations.SerializedName

data class ImagesListResponse(
    @SerializedName("fixed_height")
    val fixedHeight: FixedHeightListResponse?,
    @SerializedName("fixed_width")
    val fixedWidth: FixedWidthListResponse?,
)