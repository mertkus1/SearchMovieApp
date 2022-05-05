package com.mertkus.searchmovieapp.data.remote.dto.movie


import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("Source")
    val source: String,
    @SerializedName("Value")
    val value: String
)