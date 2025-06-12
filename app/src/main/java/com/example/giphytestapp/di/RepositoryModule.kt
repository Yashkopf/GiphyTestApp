package com.example.giphytestapp.di

import com.example.giphytestapp.data.repository.GiphyRepositoryImpl
import com.example.giphytestapp.domain.repository.GiphyRepository
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