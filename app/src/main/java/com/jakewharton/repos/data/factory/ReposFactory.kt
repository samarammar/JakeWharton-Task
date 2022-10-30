package com.jakewharton.repos.data.factory

import com.jakewharton.repos.data.source.EntityData
import com.jakewharton.repos.data.source.local.LocalEntityData
import com.jakewharton.repos.data.source.network.NetworkEntityData
import com.jakewharton.repos.util.Source
import javax.inject.Inject

class ReposFactory @Inject constructor(
    private val networkEntityData: NetworkEntityData,
    private val localEntityData: LocalEntityData
) {
    fun create(source: Source): EntityData {
        return when (source) {
            Source.NETWORK -> networkEntityData
            else -> localEntityData
        }
    }
}
