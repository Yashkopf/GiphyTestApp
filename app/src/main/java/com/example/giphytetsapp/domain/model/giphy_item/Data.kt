package com.example.giphytetsapp.domain.model.giphy_item


data class Data(
    val altText: String?,
    val analyticsResponsePayload: String?,
    val bitlyGifUrl: String?,
    val bitlyUrl: String?,
    val contentUrl: String?,
    val embedUrl: String?,
    val id: String?,
    val images: Images?,
    val importDatetime: String?,
    val isSticker: Int,
    val rating: String?,
    val slug: String?,
    val source: String?,
    val sourcePostUrl: String?,
    val sourceTld: String?,
    val title: String?,
    val trendingDatetime: String?,
    val type: String?,
    val url: String?,
    val username: String?
)