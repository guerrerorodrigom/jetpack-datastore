package com.rodrigoguerrero.spacedata.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.rodrigoguerrero.spacedata.data.SortType
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "sorting_preferences")

class DataStoreRepositoryImpl @Inject constructor(
    @ApplicationContext val context: Context
) : DataStoreRepository {

    companion object {
        private const val YEAR_SORTING = 0
        private const val NAME_SORTING = 1
    }

    private val sortingPreference = intPreferencesKey("sorting_type")

    override fun getSortingType() = context.dataStore.data
        .map { preferences ->
            when (preferences[sortingPreference]) {
                YEAR_SORTING -> SortType.Year
                NAME_SORTING -> SortType.Name
                else -> SortType.Year
            }
        }
        .catch {
            SortType.Year
        }

    override suspend fun saveSortingType(sortingType: SortType) {
        context.dataStore.edit { preferences ->
            preferences[sortingPreference] = when (sortingType) {
                SortType.Year -> YEAR_SORTING
                SortType.Name -> NAME_SORTING
            }
        }
    }
}