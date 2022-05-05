package com.mertkus.searchmovieapp.domain.repository

import com.mertkus.searchmovieapp.core.util.Resource
import com.mertkus.searchmovieapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 25.04.2022               │
//└──────────────────────────┘

interface MovieRepository {
    fun getMovie(movieImdbId: String): Flow<Resource<Movie>>
}