package com.jakewharton.repos.data.factory

import com.jakewharton.repos.data.source.EntityData
import com.jakewharton.repos.data.source.network.NetworkEntityData
import com.jakewharton.repos.util.Source
import javax.inject.Inject

class ReposFactory @Inject constructor(
    private val networkEntityData: NetworkEntityData
) {
    fun create(source: Source): EntityData {
        return networkEntityData

    }
}
