package com.mertkus.searchmovieapp.domain.model


// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 20.04.2022               │
//└──────────────────────────┘

data class Search(
    val imdbID: String,
    val poster: String,
    val title: String,
    val type: String,
    val year: String
)
