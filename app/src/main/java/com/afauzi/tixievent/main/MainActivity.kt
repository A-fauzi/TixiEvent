package com.afauzi.tixievent.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.afauzi.tixievent.main.component.NavigationDrawer
import com.afauzi.tixievent.main.component.NavigationGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable support for
        // Splash Screen API for proper Android 12+ support
        installSplashScreen()
        setContent {
            App()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            com.afauzi.tixievent.main.component.BottomNavigation(navController = navController)
        }
    ) {
        NavigationDrawer {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
            ) {
                // Content Screen
                NavigationGraph(navController = navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App()
}