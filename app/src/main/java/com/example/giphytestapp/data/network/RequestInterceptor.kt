package com.example.giphytestapp.data.network


import com.example.giphytestapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val originalUrl = request.url
        val url = originalUrl.newBuilder().apply {
            addQueryParameter(APIKEY, BuildConfig.API_KEY)
        }.build()
        val builder = request.newBuilder().url(url)

        return chain.proceed(builder.build())
    }

    private companion object {
        const val APIKEY = "api_key"
    }
}