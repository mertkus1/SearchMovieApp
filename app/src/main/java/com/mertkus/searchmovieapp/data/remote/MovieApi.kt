package com.mertkus.searchmovieapp.data.remote

import com.mertkus.searchmovieapp.data.remote.dto.movie.MovieDto
import retrofit2.http.GET
import retrofit2.http.Query

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 20.04.2022               │
//└──────────────────────────┘

interface MovieApi {
    @GET("?")
    suspend fun getMovieInfo(
        @Query("apikey") apiKey: String = "ff247114",
        @Query("i") imdbId: String,
        @Query("plot") plot: String = "full"
    ): MovieDto
}