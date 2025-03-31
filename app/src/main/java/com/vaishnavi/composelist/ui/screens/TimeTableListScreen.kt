package com.vaishnavi.composelist.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vaishnavi.composelist.data.model.Schedule
import com.vaishnavi.composelist.viewmodel.TimeTableViewModel
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeTableListScreen(timeTableViewModel: TimeTableViewModel = viewModel()) {
    val timeTables by timeTableViewModel.timeTableList.collectAsState()
    val isLoading by timeTableViewModel.isLoading.collectAsState()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Time Table") }
            )
        }
    ){paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            if (isLoading) {
                //  Show Progress Bar while API is loading
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (timeTables.isEmpty()) {
                //  Show "No data available" when API returns an empty list
                Text(text = "No data available", style = MaterialTheme.typography.bodyMedium)
            }
            else{
                LazyColumn {
                    items(timeTables) { timeTable ->
                        UserItem(timeTable)
                    }
                }
            }
        }
    }

}

@Composable
fun UserItem(user: Schedule) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = user.facultyName, style = MaterialTheme.typography.bodyLarge)
            Text(text = user.subject, style = MaterialTheme.typography.bodyMedium)
        }
    }
}