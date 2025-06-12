package com.example.giphytestapp.domain.model.giphy_list


import com.example.giphytestapp.domain.model.giphy_list.images.FixedHeightList
import com.example.giphytestapp.domain.model.giphy_list.images.FixedWidthList

data class ImagesList(
    val fixedHeight: FixedHeightList?,
    val fixedWidth: FixedWidthList?,
)