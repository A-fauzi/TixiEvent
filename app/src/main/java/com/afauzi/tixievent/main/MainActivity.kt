package com.afauzi.tixievent.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.afauzi.tixievent.main.component.NavigationDrawer
import com.afauzi.tixievent.main.component.NavigationGraph
import com.afauzi.tixievent.ui.theme.TixiEventTheme

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
    val context = LocalContext.current

    val navController = rememberNavController()
    TixiEventTheme {
        Scaffold(
            bottomBar = {
                com.afauzi.tixievent.main.component.BottomNavigation(navController = navController)
            }
        ) {
            NavigationDrawer {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    // Content Screen
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}


fun setStatusBarColor(context: Context, color: Color) {
    val window = (context as? Activity)?.window
    window?.statusBarColor = color.toArgb()
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App()
}