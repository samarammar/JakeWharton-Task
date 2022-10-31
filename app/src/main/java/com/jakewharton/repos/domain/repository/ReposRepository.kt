package com.jakewharton.repos.domain.repository

import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.model.RepoReponce
import kotlinx.coroutines.flow.Flow

interface ReposRepository {
    suspend fun getRepos(pageNumber: Int): Flow<List<RepoEntity>>
}

