package com.example.giphytetsapp.data.di

import com.example.giphytetsapp.data.repository.GiphyRepositoryImpl
import com.example.giphytetsapp.domain.repository.GiphyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(giphyRepositoryImpl: GiphyRepositoryImpl): GiphyRepository

}