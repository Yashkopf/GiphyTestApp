package com.example.giphytestapp.domain.usecases.giphy_list

import androidx.paging.PagingData
import com.example.giphytestapp.domain.model.giphy_list.GiphyItemList
import kotlinx.coroutines.flow.Flow

interface GetGiphyListUseCase {
    operator fun invoke(): Flow<PagingData<GiphyItemList>>
}