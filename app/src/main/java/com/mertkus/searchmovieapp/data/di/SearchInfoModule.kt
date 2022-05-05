package com.mertkus.searchmovieapp.data.di

import com.mertkus.searchmovieapp.data.remote.SearchApi
import com.mertkus.searchmovieapp.data.repository.SearchInfoRepositoryImpl
import com.mertkus.searchmovieapp.domain.repository.SearchInfoRepository
import com.mertkus.searchmovieapp.domain.usecase.GetSearchInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Mert KUŞ      │
//│ ──────────────────────── │
//│ mertkusdev@gmail.com     │
//│ ──────────────────────── │
//│ 20.04.2022               │
//└──────────────────────────┘

@Module
@InstallIn(SingletonComponent::class)
object SearchInfoModule {

    @Provides
    @Singleton
    fun provideGetSearchInfoUseCase(repository: SearchInfoRepository): GetSearchInfo {
        return GetSearchInfo(repository)
    }

    @Provides
    @Singleton
    fun provideSearchInfoRepository(api: SearchApi): SearchInfoRepository {
        return SearchInfoRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSearchApi(): SearchApi {
        return Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SearchApi::class.java)
    }
}