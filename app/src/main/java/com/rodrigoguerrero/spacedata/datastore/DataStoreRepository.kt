package com.rodrigoguerrero.spacedata.datastore

import com.rodrigoguerrero.spacedata.data.SortType
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    fun getSortingType(): Flow<SortType>

    fun getUserPrefs(): Flow<UserPreferences>

    suspend fun saveSortingType(sortingType: SortType)

    suspend fun saveUserPrefs(userPreferences: UserPreferences)
}