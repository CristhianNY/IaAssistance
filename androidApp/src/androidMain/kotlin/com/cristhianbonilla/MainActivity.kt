package com.cristhianbonilla

import MainView
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import com.arkivanov.decompose.retainedComponent
import navigation.RootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = retainedComponent {
            RootComponent(it)
        }
        setContent {
            MainView(root)
        }
    }
}