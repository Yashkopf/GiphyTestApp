package com.example.giphytestapp.data.network.api

import com.example.giphytestapp.data.network.model.giphy_list.GiphyDataListResponse
import retrofit2.Response
import retrofit2.http.GET

interface GiphyApi {
    @GET("v1/gifs/trending")
    suspend fun getGiphyList(): Response<GiphyDataListResponse>
}