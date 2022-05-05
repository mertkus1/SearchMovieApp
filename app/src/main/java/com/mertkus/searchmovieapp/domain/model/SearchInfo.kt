package com.mertkus.searchmovieapp.domain.model


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 20.04.2022               │
//└──────────────────────────┘

data class SearchInfo(
    val response: String,
    val search: List<Search>?,
    val totalResults: String
)