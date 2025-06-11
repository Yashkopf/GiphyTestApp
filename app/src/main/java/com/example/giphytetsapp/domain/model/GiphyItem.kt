package com.example.giphytetsapp.domain.model

import com.example.giphytetsapp.data.model.UserResponse

data class GiphyItem(

    val altText: String?,
    val analyticsResponsePayload: String?,
    val bitlyGifUrl: String?,
    val bitlyUrl: String?,
    val contentUrl: String?,
    val embedUrl: String?,
    val id: String?,
    val importDatetime: String?,
    val isSticker: Int?,
    val rating: String?,
    val slug: String?,
    val source: String?,
    val sourcePostUrl: String?,
    val sourceTld: String?,
    val title: String?,
    val trendingDatetime: String?,
    val type: String?,
    val url: String?,
    val user: UserResponse?,
    val username: String?
)
