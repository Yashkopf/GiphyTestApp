package com.example.giphytetsapp.domain.usecases.giphy_list

import androidx.paging.PagingData
import com.example.giphytetsapp.domain.model.giphy_list.GiphyItemList
import kotlinx.coroutines.flow.Flow

interface GetGiphyListUseCase {
    operator fun invoke(): Flow<PagingData<GiphyItemList>>
}