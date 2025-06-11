package com.example.giphytetsapp.data.model


import com.example.giphytetsapp.data.model.images.FixedHeightResponse
import com.example.giphytetsapp.data.model.images.FixedHeightDownsampledResponse
import com.example.giphytetsapp.data.model.images.FixedHeightSmallResponse
import com.example.giphytetsapp.data.model.images.FixedWidthResponse
import com.example.giphytetsapp.data.model.images.FixedWidthDownsampledResponse
import com.example.giphytetsapp.data.model.images.FixedWidthSmallResponse
import com.example.giphytetsapp.data.model.images.OriginalResponse
import com.google.gson.annotations.SerializedName

data class ImagesResponse(
    @SerializedName("fixed_height")
    val fixedHeight: FixedHeightResponse,
    @SerializedName("fixed_height_downsampled")
    val fixedHeightDownsampled: FixedHeightDownsampledResponse,
    @SerializedName("fixed_height_small")
    val fixedHeightSmall: FixedHeightSmallResponse,
    @SerializedName("fixed_width")
    val fixedWidth: FixedWidthResponse,
    @SerializedName("fixed_width_downsampled")
    val fixedWidthDownsampled: FixedWidthDownsampledResponse,
    @SerializedName("fixed_width_small")
    val fixedWidthSmall: FixedWidthSmallResponse,
    @SerializedName("original")
    val original: OriginalResponse
)