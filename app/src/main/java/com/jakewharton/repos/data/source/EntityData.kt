package com.jakewharton.repos.data.source

import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.model.RepoReponce
import kotlinx.coroutines.flow.Flow


interface EntityData {
    suspend fun getRepos(pageNumber: Int): List<RepoEntity>
    suspend fun AddRepos(list:List<RepoEntity>)
}