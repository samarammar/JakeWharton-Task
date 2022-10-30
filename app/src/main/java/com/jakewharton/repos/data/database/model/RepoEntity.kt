package com.jakewharton.repos.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jakewharton.repos.domain.entity.Owner


@Entity(tableName = "repo")
data class RepoEntity (
    @PrimaryKey
    val id: Long? = null,
    val name:String,
    val full_name:String,
    val url:String,
    val description:String
)


