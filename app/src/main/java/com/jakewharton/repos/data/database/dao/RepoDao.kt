package com.jakewharton.repos.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.domain.entity.Owner


@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repoList: List<RepoEntity>)

    @Query("SELECT * FROM repo ")
    fun getRepos(): List<RepoEntity>

}
