package com.vaishnavi.composelist.data.model

import com.google.gson.annotations.SerializedName

data class Schedule(
    @SerializedName("FacultyName")
    val facultyName: String,
    @SerializedName("EndTime")
    val endTime: String,
    @SerializedName("ScheduleEntryId")
    val scheduleEntryId: String,
    @SerializedName("StartTime")
    val startTime: String,
    @SerializedName("ScheduleOrder")
    val scheduleOrder: Long,
    @SerializedName("Duration")
    val duration: Long,
    @SerializedName("CohortID")
    val cohortId: String,
    @SerializedName("Subject")
    val subject: String,
    @SerializedName("FacultyID")
    val facultyId: String,
    @SerializedName("SessionStatus")
    val sessionStatus: String,
)
