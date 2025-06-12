package com.example.giphytestapp.domain.usecases.giphy_list

import androidx.paging.PagingData
import com.example.giphytestapp.domain.model.giphy_list.GiphyItemList
import com.example.giphytestapp.domain.repository.GiphyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGiphyListUseCaseImpl @Inject constructor(
    private val repository: GiphyRepository
): GetGiphyListUseCase {
    override fun invoke(): Flow<PagingData<GiphyItemList>> {
        return repository.getGiphyList()
    }
}