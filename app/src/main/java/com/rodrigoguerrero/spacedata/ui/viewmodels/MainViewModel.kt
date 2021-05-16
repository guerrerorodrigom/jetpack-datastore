package com.rodrigoguerrero.spacedata.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigoguerrero.spacedata.data.SortType
import com.rodrigoguerrero.spacedata.data.SpaceMission
import com.rodrigoguerrero.spacedata.data.SpaceMissions
import com.rodrigoguerrero.spacedata.datastore.DataStoreRepository
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

    fun getSpaceMissions() {
        viewModelScope.launch {
            dataStoreRepository.getSortingType()
                .combine(SpaceMissions()) { sortType, missions ->
                    _spaceMissions.value = when (sortType) {
                        SortType.Name -> missions.sortedBy { it.name }
                        SortType.Year -> missions.sortedBy { it.date }
                    }
                }
                .collect()
        }
    }

    fun saveSortType(sortType: SortType) {
        viewModelScope.launch {
            dataStoreRepository.saveSortingType(sortType)
            getSpaceMissions()
        }
    }
}