package com.example.giphytetsapp.data.network.model.giphy_item


import com.google.gson.annotations.SerializedName

data class GiphyResponse(
    @SerializedName("data")
    val data: DataResponse?,
    @SerializedName("meta")
    val meta: MetaResponse?
)