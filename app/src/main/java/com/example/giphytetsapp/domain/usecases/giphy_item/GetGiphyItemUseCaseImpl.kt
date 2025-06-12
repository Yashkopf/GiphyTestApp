package com.example.giphytetsapp.domain.usecases.giphy_item

import com.example.giphytetsapp.domain.model.giphy_item.Data
import com.example.giphytetsapp.domain.model.giphy_list.GiphyItemList
import com.example.giphytetsapp.domain.repository.GiphyRepository
import javax.inject.Inject

class GetGiphyItemUseCaseImpl @Inject constructor(
    private val repository: GiphyRepository
): GetGiphyItemUseCase {
    override suspend fun invoke(imageId: String): Result<Data?> {
        return repository.getGiphyItem(imageId)
    }
}