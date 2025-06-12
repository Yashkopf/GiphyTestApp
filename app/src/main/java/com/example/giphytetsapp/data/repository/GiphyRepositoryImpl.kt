package com.example.giphytetsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.giphytetsapp.data.mappers.toData
import com.example.giphytetsapp.data.network.api.GiphyApi
import com.example.giphytetsapp.data.paging.GiphyPagingSource
import com.example.giphytetsapp.data.utils.safeApiCall
import com.example.giphytetsapp.domain.model.giphy_item.Data
import com.example.giphytetsapp.domain.model.giphy_item.Giphy
import com.example.giphytetsapp.domain.model.giphy_list.GiphyItemList
import com.example.giphytetsapp.domain.repository.GiphyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GiphyRepositoryImpl @Inject constructor(
    private val api: GiphyApi
): GiphyRepository {
    override fun getGiphyList(): Flow<PagingData<GiphyItemList>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize = 25,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GiphyPagingSource(api)
            }
        ).flow
    }

    override suspend fun getGiphyItem(imageId: String): Result<Data?> {
        return safeApiCall {
            Result.success(api.getGiphyItem(imageId).body()?.data?.toData() )
        }
    }
}