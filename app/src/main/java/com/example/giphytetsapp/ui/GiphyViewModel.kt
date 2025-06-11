package com.example.giphytetsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.giphytetsapp.domain.model.GiphyItem
import com.example.giphytetsapp.domain.usecases.GetGiphyListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GiphyViewModel @Inject constructor(
    private val getGiphyListUseCase: GetGiphyListUseCase,
) : ViewModel() {

    val giphyList =
        getGiphyListUseCase.invoke().cachedIn(viewModelScope).stateIn(
            viewModelScope, SharingStarted.Lazily, PagingData.empty()
        )

}