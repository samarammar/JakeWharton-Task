package com.jakewharton.repos.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jakewharton.repos.data.database.dao.RepoDao
import com.jakewharton.repos.data.database.model.RepoEntity

@Database(
    version = 1,
    entities = [RepoEntity::class],
    exportSchema = true
)
abstract class MyRoomDatabse : RoomDatabase() {

    abstract fun repoDao(): RepoDao
}

