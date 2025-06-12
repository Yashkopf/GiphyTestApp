package com.example.giphytetsapp.ui.detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.giphytetsapp.domain.usecases.giphy_item.GetGiphyItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val getGiphyItemUseCase: GetGiphyItemUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(DetailScreenState())
    val state: State<DetailScreenState> = _state

    fun getGiphyItem(image: String) {
        _state.value = _state.value.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getGiphyItemUseCase(image).fold(
                onSuccess = {
                    _state.value = _state.value.copy(
                        giphyItem = it,
                        isLoading = false,
                        error = null
                    )
                },
                onFailure = {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = it.message
                    )
                }
            )
        }
    }
}