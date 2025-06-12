package com.example.giphytestapp.ui.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.giphytestapp.data.network.ConnectivityManager
import com.example.giphytestapp.domain.usecases.giphy_list.GetGiphyListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getGiphyListUseCase: GetGiphyListUseCase,
    private val connectivityManager: ConnectivityManager,
) : ViewModel() {

    val giphyList =
        getGiphyListUseCase.invoke().cachedIn(viewModelScope).stateIn(
            viewModelScope, SharingStarted.Lazily, PagingData.empty()
        )

    val connectivity = connectivityManager.connectionAsStateFlow.shareIn(
        viewModelScope, SharingStarted.Lazily )

}