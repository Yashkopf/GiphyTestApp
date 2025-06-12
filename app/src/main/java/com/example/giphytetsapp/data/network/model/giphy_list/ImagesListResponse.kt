package com.example.giphytetsapp.data.network.model.giphy_list


import com.example.giphytetsapp.data.network.model.giphy_list.images.FixedHeightDownsampledListResponse
import com.example.giphytetsapp.data.network.model.giphy_list.images.FixedHeightListResponse
import com.example.giphytetsapp.data.network.model.giphy_list.images.FixedWidthDownsampledListResponse
import com.example.giphytetsapp.data.network.model.giphy_list.images.FixedWidthListResponse
import com.google.gson.annotations.SerializedName

data class ImagesListResponse(
    @SerializedName("fixed_height")
    val fixedHeight: FixedHeightListResponse,
    @SerializedName("fixed_height_downsampled")
    val fixedHeightDownsampled: FixedHeightDownsampledListResponse,
    @SerializedName("fixed_width")
    val fixedWidth: FixedWidthListResponse,
    @SerializedName("fixed_width_downsampled")
    val fixedWidthDownsampled: FixedWidthDownsampledListResponse,
)