package com.mertkus.searchmovieapp.domain.usecase

import com.mertkus.searchmovieapp.core.util.Resource
import com.mertkus.searchmovieapp.domain.model.Movie
import com.mertkus.searchmovieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 25.04.2022               │
//└──────────────────────────┘

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movieImdbId: String): Flow<Resource<Movie>> {
        if (movieImdbId.isBlank()) {
            return flow { }
        }

        return repository.getMovie(movieImdbId)
    }
}