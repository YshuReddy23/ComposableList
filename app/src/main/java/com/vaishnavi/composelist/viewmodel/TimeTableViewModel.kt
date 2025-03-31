package com.vaishnavi.composelist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaishnavi.composelist.data.api.ApiService
import com.vaishnavi.composelist.data.model.Schedule
import com.vaishnavi.composelist.data.model.TimeTables
import com.vaishnavi.composelist.data.repository.ApiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TimeTableViewModel : ViewModel() {
    private val apiService = ApiService.create()
    private val apiRepository = ApiRepository(apiService)
    private var _timeTableList = MutableStateFlow<List<Schedule>>(emptyList())
    val timeTableList: StateFlow<List<Schedule>> = _timeTableList


    private var _isLoading=MutableStateFlow<Boolean>(false)
    val isLoading:StateFlow<Boolean> = _isLoading

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                _isLoading.value=true
                val response = apiRepository.getTimetables()
                if (response.isSuccessful) {
                    _isLoading.value=false
                    response.body()?.let { responseBody ->
                        _timeTableList.value = responseBody.schedule
                    } ?: run {
                        // Handle null body case (optional)
                        _timeTableList.value = emptyList()
                    }
                } else {
                    _isLoading.value=false

                    // Handle API error (optional: show a Snackbar or Log error)
                    _timeTableList.value = emptyList()
                }
            } catch (e: Exception) {
                _isLoading.value=false
                // Handle exception properly (log error or show message)
                _timeTableList.value = emptyList()
            }

        }
    }

}