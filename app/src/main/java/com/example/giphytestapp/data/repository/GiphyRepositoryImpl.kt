package com.example.giphytestapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.giphytestapp.data.network.api.GiphyApi
import com.example.giphytestapp.data.paging.GiphyPagingSource
import com.example.giphytestapp.domain.model.giphy_list.GiphyItemList
import com.example.giphytestapp.domain.repository.GiphyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GiphyRepositoryImpl @Inject constructor(
    private val api: GiphyApi
): GiphyRepository {
    override fun getGiphyList(): Flow<PagingData<GiphyItemList>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                maxSize = MAX_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GiphyPagingSource(api)
            }
        ).flow
    }
    companion object {
        const val PAGE_SIZE = 5
        const val MAX_PAGE_SIZE = 25
    }
}