package com.mertkus.searchmovieapp.presentation.screen.detailmovie

import com.mertkus.searchmovieapp.domain.model.Movie

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 25.04.2022               │
//└──────────────────────────┘

data class DetailUiState(
    val movieItems: Movie? = null,
    val isLoading: Boolean = false
)