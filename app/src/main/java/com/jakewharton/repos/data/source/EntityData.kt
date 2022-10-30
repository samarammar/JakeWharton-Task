package com.jakewharton.repos.data.source

import com.jakewharton.repos.data.model.RepoReponce


interface EntityData {
    suspend fun getRepos(): List<RepoReponce>
}