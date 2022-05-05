package com.mertkus.searchmovieapp.data.remote.dto.search


import com.google.gson.annotations.SerializedName
import com.mertkus.searchmovieapp.domain.model.SearchInfo

data class SearchInfoDto(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<SearchDto>?,
    @SerializedName("totalResults")
    val totalResults: String
) {
    fun toSearchInfo(): SearchInfo {

        if (search.isNullOrEmpty()) {
            return SearchInfo(
                response = String(),
                search = emptyList(),
                totalResults = String()
            )
        }

        return SearchInfo(
            response = response,
            search = search.map { it.toSearch() },
            totalResults = totalResults
        )
    }
}