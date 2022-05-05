package com.mertkus.searchmovieapp.data.repository

import com.mertkus.searchmovieapp.core.util.Resource
import com.mertkus.searchmovieapp.data.remote.SearchApi
import com.mertkus.searchmovieapp.domain.model.SearchInfo
import com.mertkus.searchmovieapp.domain.repository.SearchInfoRepository
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
//│ 20.04.2022               │
//└──────────────────────────┘

class SearchInfoRepositoryImpl @Inject constructor(
    private val api: SearchApi
) : SearchInfoRepository {
    override fun getSearchInfo(search: String): Flow<Resource<SearchInfo>> = flow {
        emit(
            Resource.Loading(
                SearchInfo(
                    response = String(),
                    search = emptyList(),
                    totalResults = String()
                )
            )
        )

        try {
            val searchInfos = api.getSearchInfo(search = search)
            if (searchInfos.search.isNullOrEmpty()) {
                emit(
                    Resource.Error(
                        message = "The entered word returned no results."
                    )
                )
            } else emit(Resource.Success(searchInfos.toSearchInfo()))

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