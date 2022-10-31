package com.jakewharton.repos.data.source.local

import com.jakewharton.repos.data.database.dao.RepoDao
import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.mapper.RepoEntityMapper.to
import com.jakewharton.repos.data.model.RepoReponce
import com.jakewharton.repos.data.source.EntityData
import javax.inject.Inject

class LocalEntityData @Inject constructor(
    private val repoDao: RepoDao
) : EntityData {
    override suspend fun getRepos(pageNumber: Int): List<RepoEntity> {

        return repoDao.getRepos()
    }



    override suspend fun AddRepos(list: List<RepoEntity>) {
        repoDao.insert(list)
    }


}