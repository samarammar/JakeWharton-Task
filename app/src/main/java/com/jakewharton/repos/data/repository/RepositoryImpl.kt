package com.jakewharton.repos.data.repository

import com.jakewharton.repos.data.factory.ReposFactory
import com.jakewharton.repos.data.model.RepoReponce
import com.jakewharton.repos.domain.repository.ReposRepository
import com.jakewharton.repos.util.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val factory: ReposFactory

) : ReposRepository {

    override suspend fun getRepos(): Flow<List<RepoReponce>> {
        return flow{
            emit( factory.create(Source.NETWORK).getRepos())
        }.flowOn(Dispatchers.IO)
    }
}