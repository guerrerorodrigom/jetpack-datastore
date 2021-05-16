package com.rodrigoguerrero.spacedata.datastore

import android.content.Context
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.rodrigoguerrero.spacedata.UserPrefs
import com.rodrigoguerrero.spacedata.data.SortType
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore by preferencesDataStore(name = "sorting_preferences")
private val Context.userPrefsDataStore by dataStore(
    fileName = "user_settings.pb",
    serializer = UserPrefsSerializer
)

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

    override fun getUserPrefs() = context.userPrefsDataStore.data
        .map { userPrefs ->
            UserPreferences(
                getSelected(userPrefs.mercurySelected),
                getSelected(userPrefs.geminiSelected),
                getSelected(userPrefs.apolloSelected)
            )
        }
        .catch {
            UserPreferences(true, true, true)
        }

    override suspend fun saveUserPrefs(userPreferences: UserPreferences) {
        context.userPrefsDataStore.updateData { selectedUserPrefs ->
            val apolloSelected = setSelected(userPreferences.apolloSelected)
            val geminiSelected = setSelected(userPreferences.geminiSelected)
            val mercurySelected = setSelected(userPreferences.mercurySelected)
            selectedUserPrefs.toBuilder()
                .setApolloSelected(apolloSelected)
                .setGeminiSelected(geminiSelected)
                .setMercurySelected(mercurySelected)
                .build()
        }
    }

    private fun setSelected(isSelected: Boolean) =
        if (isSelected) UserPrefs.Selected.SELECTED else UserPrefs.Selected.UNSELECTED

    private fun getSelected(selected: UserPrefs.Selected) =
        when (selected) {
            UserPrefs.Selected.NOT_SET,
            UserPrefs.Selected.SELECTED -> true
            UserPrefs.Selected.UNSELECTED -> false
            else -> true
        }
}