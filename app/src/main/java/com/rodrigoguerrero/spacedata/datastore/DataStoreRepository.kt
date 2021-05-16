package com.rodrigoguerrero.spacedata.datastore

import com.rodrigoguerrero.spacedata.data.SortType
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    fun getSortingType(): Flow<SortType>

    suspend fun saveSortingType(sortingType: SortType)
}