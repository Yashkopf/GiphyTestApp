package com.example.giphytetsapp.data.di

import com.example.giphytetsapp.domain.usecases.giphy_item.GetGiphyItemUseCase
import com.example.giphytetsapp.domain.usecases.giphy_item.GetGiphyItemUseCaseImpl
import com.example.giphytetsapp.domain.usecases.giphy_list.GetGiphyListUseCase
import com.example.giphytetsapp.domain.usecases.giphy_list.GetGiphyListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGiphyListUseCase(giphyListUseCaseImpl: GetGiphyListUseCaseImpl): GetGiphyListUseCase

    @Binds
    abstract fun bindGiphyItemUseCase(giphyItemUseCaseImpl: GetGiphyItemUseCaseImpl): GetGiphyItemUseCase
}