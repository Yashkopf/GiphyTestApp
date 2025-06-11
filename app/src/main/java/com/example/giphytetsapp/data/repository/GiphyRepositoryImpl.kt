package com.example.giphytetsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.giphytetsapp.data.api.GiphyApi
import com.example.giphytetsapp.data.paging.GiphyPagingSource
import com.example.giphytetsapp.domain.model.GiphyItem
import com.example.giphytetsapp.domain.repository.GiphyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GiphyRepositoryImpl @Inject constructor(
    private val api: GiphyApi
): GiphyRepository {
    override fun getGiphyList(): Flow<PagingData<GiphyItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 25,
                maxSize = 75,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GiphyPagingSource(api)
            }
        ).flow
    }
}