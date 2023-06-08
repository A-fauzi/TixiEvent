package com.afauzi.tixievent.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current

    // Get the current theme colors
    val currentColors = if (isSystemInDarkTheme()) darkColors() else lightColors()

    // Customize the status bar color based on the current theme
    val statusBarColor = when {
        currentColors.isLight -> MaterialTheme.colors.primarySurface // Set the desired status bar color for light theme
        else -> Color.Blue // Set the desired status bar color for dark theme
    }

    // Set the status bar color when the composition is first created
    LaunchedEffect(statusBarColor) {
        setStatusBarColor(context, statusBarColor)
    }

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
            ) {
                // Content Screen
                NavigationGraph(navController = navController)
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