package com.example.giphytetsapp.data.mappers

import com.example.giphytetsapp.data.network.model.giphy_item.DataResponse
import com.example.giphytetsapp.data.network.model.giphy_item.ImagesResponse
import com.example.giphytetsapp.data.network.model.giphy_item.OriginalMp4Response
import com.example.giphytetsapp.data.network.model.giphy_item.OriginalResponse
import com.example.giphytetsapp.data.network.model.giphy_item.OriginalStillResponse
import com.example.giphytetsapp.data.network.model.giphy_list.GiphyItemListResponse
import com.example.giphytetsapp.data.network.model.giphy_list.ImagesListResponse
import com.example.giphytetsapp.data.network.model.giphy_list.UserListResponse
import com.example.giphytetsapp.data.network.model.giphy_list.images.FixedHeightDownsampledListResponse
import com.example.giphytetsapp.data.network.model.giphy_list.images.FixedHeightListResponse
import com.example.giphytetsapp.data.network.model.giphy_list.images.FixedWidthDownsampledListResponse
import com.example.giphytetsapp.data.network.model.giphy_list.images.FixedWidthListResponse
import com.example.giphytetsapp.domain.model.giphy_item.Data
import com.example.giphytetsapp.domain.model.giphy_item.Images
import com.example.giphytetsapp.domain.model.giphy_item.Original
import com.example.giphytetsapp.domain.model.giphy_item.OriginalMp4
import com.example.giphytetsapp.domain.model.giphy_item.OriginalStill
import com.example.giphytetsapp.domain.model.giphy_list.GiphyItemList
import com.example.giphytetsapp.domain.model.giphy_list.ImagesList
import com.example.giphytetsapp.domain.model.giphy_list.UserList
import com.example.giphytetsapp.domain.model.giphy_list.images.FixedHeightList
import com.example.giphytetsapp.domain.model.giphy_list.images.FixedHeightDownsampledList
import com.example.giphytetsapp.domain.model.giphy_list.images.FixedWidthList
import com.example.giphytetsapp.domain.model.giphy_list.images.FixedWidthDownsampledList

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
        user = user?.toUserList(),
        username = username,
        images = images?.toImagesList()
    )
}

internal fun UserListResponse.toUserList(): UserList {
    return UserList(
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

internal fun ImagesListResponse.toImagesList(): ImagesList {
    return ImagesList(
        fixedHeight = fixedHeight.toFixedHeightList(),
        fixedHeightDownsampled = fixedHeightDownsampled.toFixedHeightDownsampledList(),
        fixedWidth = fixedWidth.toFixedWidthList(),
        fixedWidthDownsampled = fixedWidthDownsampled.toFixedWidthDownsampledList(),
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

internal fun FixedHeightDownsampledListResponse.toFixedHeightDownsampledList(): FixedHeightDownsampledList {
    return FixedHeightDownsampledList(
        height = height,
        size = size,
        url = url,
        webp = webp,
        webpSize = webpSize,
        width = width
    )
}

internal fun FixedWidthDownsampledListResponse.toFixedWidthDownsampledList(): FixedWidthDownsampledList {
    return FixedWidthDownsampledList(
        height = height,
        size = size,
        url = url,
        webp = webp,
        webpSize = webpSize,
        width = width
    )
}

internal fun DataResponse.toData(): Data {
    return Data(
        altText = altText,
        analyticsResponsePayload = analyticsResponsePayload,
        bitlyGifUrl = bitlyGifUrl,
        bitlyUrl = bitlyUrl,
        contentUrl = contentUrl,
        embedUrl = embedUrl,
        id = id,
        images = images?.toImages(),
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
        username = username
    )
}

internal fun ImagesResponse.toImages(): Images {
    return Images(
        original = original?.toOriginal(),
        originalMp4 = originalMp4?.toOriginalMp4(),
        originalStill = originalStill?.toOriginalStill()
    )
}

internal fun OriginalResponse.toOriginal(): Original{
    return Original(
        frames = frames,
        hash = hash,
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

internal fun OriginalMp4Response.toOriginalMp4(): OriginalMp4 {
    return OriginalMp4(
        height = height,
        mp4 = mp4,
        mp4Size = mp4Size,
        width = width
    )
}

internal fun OriginalStillResponse.toOriginalStill(): OriginalStill {
    return OriginalStill(
        height = height,
        size = size,
        url = url,
        width = width
    )
}