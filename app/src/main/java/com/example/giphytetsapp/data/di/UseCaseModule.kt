package com.example.giphytetsapp.data.di

import com.example.giphytetsapp.domain.usecases.GetGiphyListUseCase
import com.example.giphytetsapp.domain.usecases.GetGiphyListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun provideGiphyListUseCase(giphyListUseCaseImpl: GetGiphyListUseCaseImpl): GetGiphyListUseCase
}