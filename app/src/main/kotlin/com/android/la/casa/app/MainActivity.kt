package com.android.la.casa.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.android.la.casa.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeScreen()
        }
    }
}


@Composable
fun MyName(name: String){
    Row {
        Text(text = name)
        Text(text = name)
    }

}

//@Preview(showBackground = true)
@Composable
fun Show(){
    Column(){
        Text(text = "hi")
        MyName("Ramzy Ahmed")
    }

}