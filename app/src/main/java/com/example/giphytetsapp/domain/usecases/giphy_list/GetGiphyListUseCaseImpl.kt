package com.example.giphytetsapp.domain.usecases.giphy_list

import androidx.paging.PagingData
import com.example.giphytetsapp.domain.model.giphy_list.GiphyItemList
import com.example.giphytetsapp.domain.repository.GiphyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGiphyListUseCaseImpl @Inject constructor(
    private val repository: GiphyRepository
): GetGiphyListUseCase {
    override fun invoke(): Flow<PagingData<GiphyItemList>> {
        return repository.getGiphyList()
    }
}