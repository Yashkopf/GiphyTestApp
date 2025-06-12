package com.example.giphytestapp.di

import android.content.Context
import com.example.giphytestapp.data.network.ConnectivityManager
import com.example.giphytestapp.data.network.RequestInterceptor
import com.example.giphytestapp.data.network.api.GiphyApi
import com.example.giphytestapp.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun connectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return ConnectivityManager(context)
    }

    @Singleton
    @Provides
    fun provideRequestInterceptor(): RequestInterceptor {
        return RequestInterceptor()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(45L, TimeUnit.SECONDS)
            .connectTimeout(45L, TimeUnit.SECONDS)
            .writeTimeout(45L, TimeUnit.SECONDS)
            .addInterceptor(provideRequestInterceptor())
            .addInterceptor(provideHttpLoggingInterceptor())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(): GiphyApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(GiphyApi::class.java)
    }

}