package com.example.giphytetsapp.data.network.api

import com.example.giphytetsapp.data.network.model.giphy_item.DataResponse
import com.example.giphytetsapp.data.network.model.giphy_item.GiphyResponse
import com.example.giphytetsapp.data.network.model.giphy_list.GiphyDataListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GiphyApi {
    @GET("v1/gifs/trending")
    suspend fun getGiphyList(): Response<GiphyDataListResponse>

    @GET("v1/gifs/{imageId}")
    suspend fun getGiphyItem(
        @Path("imageId") imageId: String
    ): Response<GiphyResponse>
}