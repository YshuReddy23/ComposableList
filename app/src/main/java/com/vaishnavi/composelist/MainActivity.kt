package com.vaishnavi.composelist

import com.vaishnavi.composelist.ui.theme.ComposeListTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.vaishnavi.composelist.ui.screens.TimeTableListScreen
import com.vaishnavi.composelist.viewmodel.TimeTableViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val userViewModel = ViewModelProvider(this).get(TimeTableViewModel::class.java)

        setContent {
            ComposeListTheme {
              TimeTableListScreen()
            }
        }
    }
}
