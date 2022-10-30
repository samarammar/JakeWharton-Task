package com.jakewharton.repos.data.source.network

import com.jakewharton.repos.data.api.ApiService
import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.model.RepoReponce
import com.jakewharton.repos.data.source.EntityData
import javax.inject.Inject

class NetworkEntityData @Inject constructor(
    private val apiService: ApiService
) : EntityData {
    override suspend fun getRepos(): List<RepoEntity> {
        return apiService.getRepos()
    }

    override suspend fun AddRepos(list: List<RepoEntity>) {

    }


}