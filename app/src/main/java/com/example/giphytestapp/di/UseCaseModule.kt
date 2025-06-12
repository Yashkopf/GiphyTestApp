package com.example.giphytestapp.di

import com.example.giphytestapp.domain.usecases.giphy_list.GetGiphyListUseCase
import com.example.giphytestapp.domain.usecases.giphy_list.GetGiphyListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGiphyListUseCase(giphyListUseCaseImpl: GetGiphyListUseCaseImpl): GetGiphyListUseCase

}