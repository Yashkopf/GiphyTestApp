package com.example.giphytetsapp.data.model

import com.google.gson.annotations.SerializedName

data class PaginationInfoResponse(
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("count")
    val count: Int,
)
