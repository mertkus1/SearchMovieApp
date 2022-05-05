package com.mertkus.searchmovieapp.presentation.screen.searchinfo

import com.mertkus.searchmovieapp.domain.model.SearchInfo

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 20.04.2022               │
//└──────────────────────────┘

data class SearchInfoState(
    val searchInfoItems: SearchInfo? = null,
    val isLoading: Boolean
)
