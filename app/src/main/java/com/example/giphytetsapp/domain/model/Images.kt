package com.example.giphytetsapp.domain.model


import com.example.giphytetsapp.data.model.images.FixedHeightResponse
import com.example.giphytetsapp.data.model.images.FixedHeightDownsampledResponse
import com.example.giphytetsapp.data.model.images.FixedHeightSmallResponse
import com.example.giphytetsapp.data.model.images.FixedWidthResponse
import com.example.giphytetsapp.data.model.images.FixedWidthDownsampledResponse
import com.example.giphytetsapp.data.model.images.FixedWidthSmallResponse
import com.example.giphytetsapp.data.model.images.OriginalResponse

data class Images(
    val fixedHeight: FixedHeightResponse,
    val fixedHeightDownsampled: FixedHeightDownsampledResponse,
    val fixedHeightSmall: FixedHeightSmallResponse,
    val fixedWidth: FixedWidthResponse,
    val fixedWidthDownsampled: FixedWidthDownsampledResponse,
    val fixedWidthSmall: FixedWidthSmallResponse,
    val original: OriginalResponse
)