package com.example.giphytestapp.data.mappers

import com.example.giphytestapp.data.network.model.giphy_list.GiphyItemListResponse
import com.example.giphytestapp.data.network.model.giphy_list.ImagesListResponse
import com.example.giphytestapp.data.network.model.giphy_list.images.FixedHeightListResponse
import com.example.giphytestapp.data.network.model.giphy_list.images.FixedWidthListResponse
import com.example.giphytestapp.domain.model.giphy_list.GiphyItemList
import com.example.giphytestapp.domain.model.giphy_list.ImagesList
import com.example.giphytestapp.domain.model.giphy_list.images.FixedHeightList
import com.example.giphytestapp.domain.model.giphy_list.images.FixedWidthList

internal fun GiphyItemListResponse.toGiphyItemList(): GiphyItemList {
    return GiphyItemList(
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
        username = username,
        images = images?.toImagesList()
    )
}

internal fun ImagesListResponse.toImagesList(): ImagesList {
    return ImagesList(
        fixedHeight = fixedHeight?.toFixedHeightList(),
        fixedWidth = fixedWidth?.toFixedWidthList(),
    )
}

internal fun FixedHeightListResponse.toFixedHeightList(): FixedHeightList {
    return FixedHeightList(
        height = height,
        mp4 = mp4,
        mp4Size = mp4Size,
        size = size,
        url = url,
        webp = webp,
        webpSize = webpSize,
        width = width
    )
}

internal fun FixedWidthListResponse.toFixedWidthList(): FixedWidthList {
    return FixedWidthList(
        height = height,
        mp4 = mp4,
        mp4Size = mp4Size,
        size = size,
        url = url,
        webp = webp,
        webpSize = webpSize,
        width = width
    )
}

