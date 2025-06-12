package com.example.giphytetsapp.domain.repository

import androidx.paging.PagingData
import com.example.giphytetsapp.domain.model.giphy_item.Data
import com.example.giphytetsapp.domain.model.giphy_item.Giphy
import com.example.giphytetsapp.domain.model.giphy_list.GiphyItemList
import kotlinx.coroutines.flow.Flow

interface GiphyRepository {

   fun getGiphyList(): Flow<PagingData<GiphyItemList>>
   suspend fun getGiphyItem(imageId: String): Result<Data?>
}