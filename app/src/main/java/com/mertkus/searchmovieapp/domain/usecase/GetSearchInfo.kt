package com.mertkus.searchmovieapp.domain.usecase

import com.mertkus.searchmovieapp.core.util.Resource
import com.mertkus.searchmovieapp.domain.model.SearchInfo
import com.mertkus.searchmovieapp.domain.repository.SearchInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 20.04.2022               │
//└──────────────────────────┘

class GetSearchInfo @Inject constructor(
    private val repository: SearchInfoRepository
) {

    operator fun invoke(search: String): Flow<Resource<SearchInfo>> {
        if (search.isBlank()) {
            return flow { }
        }

        return repository.getSearchInfo(search)
    }

}