package com.example.giphytetsapp.data.network.model.giphy_item


import com.google.gson.annotations.SerializedName

data class MetaResponse(
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("response_id")
    val responseId: String?,
    @SerializedName("status")
    val status: Int?
)