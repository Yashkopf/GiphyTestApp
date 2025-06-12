package com.example.giphytetsapp.data.network.model.giphy_list

import com.google.gson.annotations.SerializedName

data class PaginationInfoListResponse(
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("count")
    val count: Int,
)
