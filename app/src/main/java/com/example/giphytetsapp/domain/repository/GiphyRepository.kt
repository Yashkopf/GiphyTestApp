package com.example.giphytetsapp.domain.repository

import androidx.paging.PagingData
import com.example.giphytetsapp.domain.model.GiphyItem
import kotlinx.coroutines.flow.Flow

interface GiphyRepository {

   fun getGiphyList(): Flow<PagingData<GiphyItem>>
}