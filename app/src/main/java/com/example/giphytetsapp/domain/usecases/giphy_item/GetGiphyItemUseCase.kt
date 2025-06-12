package com.example.giphytetsapp.domain.usecases.giphy_item

import com.example.giphytetsapp.domain.model.giphy_item.Data
import com.example.giphytetsapp.domain.model.giphy_list.GiphyItemList

interface GetGiphyItemUseCase {
    suspend operator fun invoke(imageId: String): Result<Data?>
}