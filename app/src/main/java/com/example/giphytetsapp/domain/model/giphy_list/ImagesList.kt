package com.example.giphytetsapp.domain.model.giphy_list


import com.example.giphytetsapp.domain.model.giphy_list.images.FixedHeightList
import com.example.giphytetsapp.domain.model.giphy_list.images.FixedHeightDownsampledList
import com.example.giphytetsapp.domain.model.giphy_list.images.FixedWidthList
import com.example.giphytetsapp.domain.model.giphy_list.images.FixedWidthDownsampledList

data class ImagesList(
    val fixedHeight: FixedHeightList,
    val fixedHeightDownsampled: FixedHeightDownsampledList,
    val fixedWidth: FixedWidthList,
    val fixedWidthDownsampled: FixedWidthDownsampledList,
)