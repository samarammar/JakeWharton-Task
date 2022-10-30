package com.jakewharton.repos.data.api

import com.jakewharton.repos.data.model.RepoReponce
import retrofit2.http.GET

interface ApiService {

    @GET("repos")
    suspend fun getRepos(): List<RepoReponce>
}