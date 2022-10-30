package com.jakewharton.repos.di

import com.jakewharton.repos.data.repository.RepositoryImpl
import com.jakewharton.repos.domain.repository.ReposRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {


    @Binds
    abstract fun bindProductRepository(repository: RepositoryImpl): ReposRepository
}

