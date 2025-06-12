package com.example.giphytetsapp.ui.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.giphytetsapp.domain.usecases.giphy_list.GetGiphyListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getGiphyListUseCase: GetGiphyListUseCase,
) : ViewModel() {

    val giphyList =
        getGiphyListUseCase.invoke().cachedIn(viewModelScope).stateIn(
            viewModelScope, SharingStarted.Lazily, PagingData.empty()
        )

}