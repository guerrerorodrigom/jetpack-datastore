package com.rodrigoguerrero.spacedata.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigoguerrero.spacedata.data.SortType
import com.rodrigoguerrero.spacedata.data.SpaceMission
import com.rodrigoguerrero.spacedata.data.SpaceMissions
import com.rodrigoguerrero.spacedata.data.SpaceProgram
import com.rodrigoguerrero.spacedata.datastore.DataStoreRepository
import com.rodrigoguerrero.spacedata.datastore.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _spaceMissions: MutableLiveData<List<SpaceMission>> = MutableLiveData()
    val spaceMissions: LiveData<List<SpaceMission>>
        get() = _spaceMissions
    private val _userPrefs = MutableLiveData<UserPreferences>()
    val userPrefs: LiveData<UserPreferences>
        get() = _userPrefs

    fun getSpaceMissions() {
        viewModelScope.launch {
            retrieveSpaceMissions()
        }
    }

    fun saveSortType(sortType: SortType) {
        viewModelScope.launch {
            dataStoreRepository.saveSortingType(sortType)
            getSpaceMissions()
        }
    }

    fun showApollo(checked: Boolean) {
        updateUserPrefs(_userPrefs.value?.copy(apolloSelected = checked))
    }

    fun showGemini(checked: Boolean) {
        updateUserPrefs(_userPrefs.value?.copy(geminiSelected = checked))
    }

    fun showMercury(checked: Boolean) {
        updateUserPrefs(_userPrefs.value?.copy(mercurySelected = checked))
    }

    private fun updateUserPrefs(userPrefs: UserPreferences?) {
        viewModelScope.launch {
            userPrefs?.let {
                dataStoreRepository.saveUserPrefs(userPrefs)
                retrieveSpaceMissions()
            }
        }
    }

    private suspend fun retrieveSpaceMissions() {
        val selectedFilterFlow = dataStoreRepository.getUserPrefs()
        val sortingTypeFlow = dataStoreRepository.getSortingType()
        combine(
            sortingTypeFlow,
            SpaceMissions(),
            selectedFilterFlow
        ) { sortType, missions, userPrefs ->
            _userPrefs.value = userPrefs
            _spaceMissions.value = when (sortType) {
                SortType.Name -> missions.filter { mission ->
                    filterMissions(userPrefs, mission)
                }.sortedBy { it.name }
                SortType.Year -> missions.filter { mission ->
                    filterMissions(userPrefs, mission)
                }.sortedBy { it.date }
            }
        }.collect()
    }

    private fun filterMissions(
        userPrefs: UserPreferences,
        mission: SpaceMission
    ) = ((userPrefs.mercurySelected && mission.program is SpaceProgram.Mercury)
        || (userPrefs.geminiSelected && mission.program is SpaceProgram.Gemini)
        || (userPrefs.apolloSelected && mission.program is SpaceProgram.Apollo))
}