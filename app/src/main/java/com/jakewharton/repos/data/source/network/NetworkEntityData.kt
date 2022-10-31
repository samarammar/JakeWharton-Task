package com.jakewharton.repos.data.source.network

import com.jakewharton.repos.data.api.ApiService
import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.model.RepoReponce
import com.jakewharton.repos.data.source.EntityData
import javax.inject.Inject

class NetworkEntityData @Inject constructor(
    private val apiService: ApiService
) : EntityData {
    override suspend fun getRepos(pageNumber: Int): List<RepoEntity> {
//        Pager(PagingConfig(pageSize = 1)) {
//            ReposRemoteMediator(database, apiService)
//
//        }.flow
        return apiService.getRepos(pageNumber)
    }

    override suspend fun AddRepos(list: List<RepoEntity>) {

    }


}