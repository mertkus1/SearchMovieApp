package com.mertkus.searchmovieapp.data.repository

import com.mertkus.searchmovieapp.core.util.Resource
import com.mertkus.searchmovieapp.data.remote.MovieApi
import com.mertkus.searchmovieapp.domain.model.Movie
import com.mertkus.searchmovieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 25.04.2022               │
//└──────────────────────────┘

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
) : MovieRepository {
    override fun getMovie(movieImdbId: String): Flow<Resource<Movie>> = flow {
        emit(Resource.Loading())

        try {
            val movie = api.getMovieInfo(imdbId = movieImdbId)
            emit(Resource.Success(movie.toMovie()))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection."
                )
            )
        }

    }
}