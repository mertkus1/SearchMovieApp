package com.mertkus.searchmovieapp.presentation.screen.searchinfo

import androidx.lifecycle.viewModelScope
import com.mertkus.searchmovieapp.core.base.BaseViewModel
import com.mertkus.searchmovieapp.core.util.Resource
import com.mertkus.searchmovieapp.domain.usecase.GetSearchInfo
import dagger.hilt.android.lifecycle.HiltViewModel
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
//│ 20.04.2022               │
//└──────────────────────────┘

@HiltViewModel
class SearchInfoViewModel @Inject constructor(
    private val getSearchInfo: GetSearchInfo
) : BaseViewModel() {

    private val _state: MutableStateFlow<SearchInfoState> =
        MutableStateFlow(SearchInfoState(isLoading = false))
    val state: StateFlow<SearchInfoState> get() = _state

    fun onSearch(query: String) {
        job?.cancel()
        job = viewModelScope.launch {
            getSearchInfo(query)
                .onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                searchInfoItems = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                searchInfoItems = result.data,
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                searchInfoItems = result.data,
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}