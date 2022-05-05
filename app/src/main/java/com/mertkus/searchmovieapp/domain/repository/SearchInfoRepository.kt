package com.mertkus.searchmovieapp.domain.repository

import com.mertkus.searchmovieapp.core.util.Resource
import com.mertkus.searchmovieapp.domain.model.SearchInfo
import kotlinx.coroutines.flow.Flow

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 20.04.2022               │
//└──────────────────────────┘

interface SearchInfoRepository {
    fun getSearchInfo(search: String): Flow<Resource<SearchInfo>>
}