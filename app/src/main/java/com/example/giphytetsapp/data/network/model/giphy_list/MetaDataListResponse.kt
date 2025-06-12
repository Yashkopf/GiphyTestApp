package com.example.giphytetsapp.data.network.model.giphy_list

import com.google.gson.annotations.SerializedName

data class MetaDataListResponse (
    @SerializedName("msg")
    val msg: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("response_id")
    val responseId: String
)