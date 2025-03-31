package com.vaishnavi.composelist.data.api

import com.vaishnavi.composelist.data.model.Schedule
import com.vaishnavi.composelist.data.model.TimeTables
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("CITY%23268/classroom/CLASSROOM%23664515/schedule")
    suspend fun getUsers(): Response<TimeTables>

    companion object {
        private const val BASE_URL =
            "https://kf9hz4h43a.execute-api.us-east-1.amazonaws.com/Dev1/ClassRoomSchedule/v1/institute/impulse/location/"

        fun create(): ApiService {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY  // Log full request & response body
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }

}