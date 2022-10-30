package com.jakewharton.repos.data.mapper

import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.model.RepoReponce

object RepoEntityMapper {

    fun List<RepoEntity>.to(): List<RepoReponce> {
        val repos = ArrayList<RepoReponce>()
        forEach {
            repos.add(RepoReponce(it.name, it.full_name, it.url, it.description, it.id!!))
        }

        return repos
    }
}