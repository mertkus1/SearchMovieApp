package com.mertkus.searchmovieapp.data.remote.dto.movie


import com.google.gson.annotations.SerializedName
import com.mertkus.searchmovieapp.domain.model.Movie

data class MovieDto(
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("Awards")
    val awards: String,
    @SerializedName("BoxOffice")
    val boxOffice: String,
    @SerializedName("Country")
    val country: String,
    @SerializedName("DVD")
    val dvd: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Genre")
    val genre: String,
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("imdbRating")
    val imdbRating: String,
    @SerializedName("imdbVotes")
    val imdbVotes: String,
    @SerializedName("Language")
    val language: String,
    @SerializedName("Metascore")
    val metascore: String,
    @SerializedName("Plot")
    val plot: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Production")
    val production: String,
    @SerializedName("Rated")
    val rated: String,
    @SerializedName("Ratings")
    val ratings: List<RatingDto>,
    @SerializedName("Released")
    val released: String,
    @SerializedName("Response")
    val response: String,
    @SerializedName("Runtime")
    val runtime: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Website")
    val website: String,
    @SerializedName("Writer")
    val writer: String,
    @SerializedName("Year")
    val year: String
) {
    fun toMovie(): Movie {
        return Movie(
            actors = actors,
            awards = awards,
            boxOffice = boxOffice,
            country = country,
            dvd = dvd,
            director = director,
            genre = genre,
            imdbID = imdbID,
            imdbRating = imdbRating,
            imdbVotes = imdbVotes,
            language = language,
            metascore = metascore,
            plot = plot,
            poster = poster,
            production = production,
            rated = rated,
            ratings = ratings,
            released = released,
            response = response,
            runtime = runtime,
            title = title,
            type = type,
            website = website,
            writer = writer,
            year = year
        )
    }
}