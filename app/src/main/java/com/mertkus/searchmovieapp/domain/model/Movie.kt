package com.mertkus.searchmovieapp.domain.model

import com.mertkus.searchmovieapp.data.remote.dto.movie.RatingDto

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 25.04.2022               │
//└──────────────────────────┘

data class Movie(
    val actors: String?,
    val awards: String?,
    val boxOffice: String?,
    val country: String?,
    val dvd: String?,
    val director: String?,
    val genre: String?,
    val imdbID: String?,
    val imdbRating: String?,
    val imdbVotes: String?,
    val language: String?,
    val metascore: String?,
    val plot: String?,
    val poster: String?,
    val production: String?,
    val rated: String?,
    val ratings: List<RatingDto>?,
    val released: String?,
    val response: String?,
    val runtime: String?,
    val title: String?,
    val type: String?,
    val website: String?,
    val writer: String?,
    val year: String?
)
