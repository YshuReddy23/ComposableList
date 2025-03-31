package com.vaishnavi.composelist.data.repository

import com.vaishnavi.composelist.data.api.ApiService
import com.vaishnavi.composelist.data.model.Schedule
import com.vaishnavi.composelist.data.model.TimeTables
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ApiRepository(private val apiService: ApiService) {
    suspend fun getTimetables():Response<TimeTables> {
         return withContext(Dispatchers.IO) {
            apiService.getUsers()
        }
    }
}