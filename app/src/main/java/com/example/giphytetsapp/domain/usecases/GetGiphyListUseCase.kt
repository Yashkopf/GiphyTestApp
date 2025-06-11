package com.example.giphytetsapp.domain.usecases

import androidx.paging.PagingData
import com.example.giphytetsapp.domain.model.GiphyItem
import kotlinx.coroutines.flow.Flow

interface GetGiphyListUseCase {
    operator fun invoke(): Flow<PagingData<GiphyItem>>
}