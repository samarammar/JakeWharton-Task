package com.jakewharton.repos.data.api

import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.model.RepoReponce
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("repos")
    suspend fun getRepos(
        @Query("page") page: Int = 1,
    ): List<RepoEntity>
}