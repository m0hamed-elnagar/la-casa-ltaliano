package com.appventure.la.casa.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.appventure.la.casa.ui.navigation.RoutesManger

class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       viewModel //to ensure init the viewmodel
        setContent {
            RoutesManger()
        }
    }
}