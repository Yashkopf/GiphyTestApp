package com.example.giphytestapp.domain.repository

import androidx.paging.PagingData
import com.example.giphytestapp.domain.model.giphy_list.GiphyItemList
import kotlinx.coroutines.flow.Flow

interface GiphyRepository {

   fun getGiphyList(): Flow<PagingData<GiphyItemList>>
}