package com.mertkus.searchmovieapp.data.remote.dto.search


import com.google.gson.annotations.SerializedName
import com.mertkus.searchmovieapp.domain.model.Search

data class SearchDto(
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Year")
    val year: String
) {
    fun toSearch(): Search {
        return Search(
            imdbID = imdbID,
            poster = poster,
            title = title,
            type = type,
            year = year
        )
    }
}