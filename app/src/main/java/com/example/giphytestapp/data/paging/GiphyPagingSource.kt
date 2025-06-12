package com.example.giphytestapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.giphytestapp.data.mappers.toGiphyItemList
import com.example.giphytestapp.data.network.api.GiphyApi
import com.example.giphytestapp.domain.model.giphy_list.GiphyItemList
import retrofit2.HttpException

class GiphyPagingSource(
    private val giphyApi: GiphyApi
) : PagingSource<Int, GiphyItemList>() {

    override fun getRefreshKey(state: PagingState<Int, GiphyItemList>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GiphyItemList> {

        try {
            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
            val response =
                giphyApi.getGiphyList()

            if (response.isSuccessful) {
                val result = checkNotNull(response.body()?.data).map { it.toGiphyItemList() }
                val prevKey = if (pageNumber > 1) pageNumber - 1 else null
                val nextKey = if (result.isEmpty()) null else pageNumber + 1

                return LoadResult.Page(result, prevKey, nextKey)
            } else {
                return LoadResult.Error(HttpException(response))
            }
        } catch (e: Exception){
            return LoadResult.Error(e)
        }
    }

    companion object {

        const val INITIAL_PAGE_NUMBER = 1
    }
}