package com.example.giphytetsapp.ui.detail_screen

import com.example.giphytetsapp.domain.model.giphy_item.Data

data class DetailScreenState(
    val giphyItem: Data? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
