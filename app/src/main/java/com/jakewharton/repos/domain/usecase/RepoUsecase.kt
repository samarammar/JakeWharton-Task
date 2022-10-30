package com.jakewharton.repos.domain.usecase

import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.model.RepoReponce
import com.jakewharton.repos.domain.repository.ReposRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepoUsecase @Inject constructor(
    private val repoRepository: ReposRepository
) {

    suspend fun execute(): Flow<List<RepoEntity>> {
        return repoRepository.getRepos()
    }

}