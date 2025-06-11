package com.example.giphytetsapp.data.api

import com.example.giphytetsapp.BuildConfig
import com.example.giphytetsapp.data.model.GiphyDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {
    @GET("v1/gifs/trending")
    suspend fun getGiphyList(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<GiphyDataResponse>

}