package com.example.giphytestapp.data.network.model.giphy_list

import com.google.gson.annotations.SerializedName

data class GiphyDataListResponse (
    @SerializedName("data")
    val data: List<GiphyItemListResponse>?
)