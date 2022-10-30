package com.jakewharton.repos.presentation.reposlist

import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.model.RepoReponce
import kotlinx.coroutines.flow.Flow

data class ReposListUiState (
    val repos: Flow<List<RepoEntity>>
)