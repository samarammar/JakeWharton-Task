package com.jakewharton.repos.data.repository

import com.bumptech.glide.load.engine.Resource
import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.factory.ReposFactory
import com.jakewharton.repos.data.model.RepoReponce
import com.jakewharton.repos.domain.repository.ReposRepository
import com.jakewharton.repos.util.ExceptionParser
import com.jakewharton.repos.util.Source
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val factory: ReposFactory

) : ReposRepository {


    override suspend fun getRepos(pageNumber: Int): Flow<List<RepoEntity>> {
        return flow{
            try {
                val data= factory.create(Source.NETWORK).getRepos(pageNumber)

                factory.create(Source.LOCAL).AddRepos(data)

                emit(data)
            }catch (ex: Exception) {

                try {
                    // Get data from LocalDataSource
                    val localData = factory.create(Source.LOCAL).getRepos(pageNumber)
                    // Emit data
                    emit(localData)
                } catch (ex1: Exception) {
                    // Emit error
                    ExceptionParser.getMessage(ex1)
//                    emit(ExceptionParser.getMessage(ex1))
                }
            }



        }.flowOn(Dispatchers.IO)
    }
//
//    private suspend fun syncRepos(): Flow<List<RepoEntity>> {
//        return flow {
//            emit(
//                factory.create(Source.NETWORK).getRepos()
//                    .also { reposFromNetwork ->
//                        factory.create(Source.LOCAL).AddRepos(reposFromNetwork)
//                    }
//            )
//        }.flowOn(Dispatchers.IO)
//    }
}

