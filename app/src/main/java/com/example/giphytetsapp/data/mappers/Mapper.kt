package com.example.giphytetsapp.data.mappers

import com.example.giphytetsapp.data.model.GiphyItemResponse
import com.example.giphytetsapp.data.model.UserResponse
import com.example.giphytetsapp.domain.model.GiphyItem
import com.example.giphytetsapp.domain.model.User

internal fun GiphyItemResponse.toGiphyItem(): GiphyItem{
    return GiphyItem(
        altText = altText,
        analyticsResponsePayload = analyticsResponsePayload,
        bitlyGifUrl = bitlyGifUrl,
        bitlyUrl = bitlyUrl,
        contentUrl = contentUrl,
        embedUrl = embedUrl,
        id = id,
        importDatetime = importDatetime,
        isSticker = isSticker,
        rating = rating,
        slug = slug,
        source = source,
        sourcePostUrl = sourcePostUrl,
        sourceTld = sourceTld,
        title = title,
        trendingDatetime = trendingDatetime,
        type = type,
        url = url,
        user = user,
        username = username
    )
}

internal fun UserResponse.toUser(): User {
    return User(
        avatarUrl = avatarUrl,
        bannerImage = bannerImage,
        bannerUrl = bannerUrl,
        description = description,
        displayName = displayName,
        instagramUrl = instagramUrl,
        isVerified = isVerified,
        profileUrl = profileUrl,
        username = username,
        websiteUrl = websiteUrl
    )
}