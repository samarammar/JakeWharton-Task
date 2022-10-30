package com.jakewharton.repos.di

import android.content.Context
import androidx.room.Room
import com.jakewharton.repos.data.database.MyRoomDatabse
import com.jakewharton.repos.data.database.dao.RepoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DB_NAME = "repo_db"

    @Provides
    fun provideMyRoomDatabase(@ApplicationContext context: Context): MyRoomDatabse {
        return Room.databaseBuilder(
            context,
            MyRoomDatabse::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    fun provideRepoDao(myRoomDatabase: MyRoomDatabse): RepoDao {
        return myRoomDatabase.repoDao()
    }
}

