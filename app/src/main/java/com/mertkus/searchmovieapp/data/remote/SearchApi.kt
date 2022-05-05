package com.mertkus.searchmovieapp.data.remote

import com.mertkus.searchmovieapp.data.remote.dto.search.SearchInfoDto
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

interface SearchApi {
    @GET("?")
    suspend fun getSearchInfo(
        @Query("apikey") apiKey: String = "ff247114",
        @Query("s") search: String
    ): SearchInfoDto
}