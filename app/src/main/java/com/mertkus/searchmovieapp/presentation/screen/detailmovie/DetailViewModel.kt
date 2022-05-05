package com.mertkus.searchmovieapp.presentation.screen.detailmovie

import androidx.lifecycle.viewModelScope
import com.mertkus.searchmovieapp.core.base.BaseViewModel
import com.mertkus.searchmovieapp.core.util.Resource
import com.mertkus.searchmovieapp.domain.usecase.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 25.04.2022               │
//└──────────────────────────┘

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase
) : BaseViewModel() {
    private val _state: MutableStateFlow<DetailUiState> =
        MutableStateFlow(DetailUiState(isLoading = true))
    val state: StateFlow<DetailUiState> get() = _state

    fun onMovie(imdbId: String) {
        job?.cancel()
        job = viewModelScope.launch {
            delay(50L)
            getMovieUseCase(imdbId)
                .onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                movieItems = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                movieItems = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                movieItems = result.data,
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }

}