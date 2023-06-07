package com.afauzi.tixievent.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.afauzi.tixievent.R
import com.afauzi.tixievent.main.MainActivity.BottomNavItem
import com.afauzi.tixievent.main.fragment_screen.EventScreen
import com.afauzi.tixievent.main.fragment_screen.ExploreScreen
import com.afauzi.tixievent.main.fragment_screen.MapScreen
import com.afauzi.tixievent.main.fragment_screen.ProfileScreen
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.afauzi.tixievent.main.fragment_screen.AddEventScreen

class MainActivity : ComponentActivity() {
    sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
        object Explore : BottomNavItem("Explore", R.raw.explore_filled, "explore")
        object Event : BottomNavItem("Event", R.raw.calender_filled, "event")
        object AddEvent : BottomNavItem("AddEvent", R.raw.add_event, "addEvent")
        object Map : BottomNavItem("Map", R.raw.map_filled, "map")
        object Profile : BottomNavItem("Profile", R.raw.user_filled, "profile")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            BottomNavigation(navController = navController)
        }
    ) {

        NavigationGraph(navController = navController)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Explore.screen_route
    ) {
        composable(BottomNavItem.Explore.screen_route) {
            ExploreScreen()
        }
        composable(BottomNavItem.Event.screen_route) {
            EventScreen()
        }
        composable(BottomNavItem.AddEvent.screen_route) {
            AddEventScreen()
        }
        composable(BottomNavItem.Map.screen_route) {
            MapScreen()
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileScreen()
        }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Explore,
        BottomNavItem.Event,
        BottomNavItem.AddEvent,
        BottomNavItem.Map,
        BottomNavItem.Profile
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.Black
    ) {
        val imageLoader = ImageLoader.Builder(LocalContext.current)
            .components {
                add(SvgDecoder.Factory())
            }
            .build()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = rememberAsyncImagePainter(model  = item.icon, imageLoader),
                        contentDescription = item.title)
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App()
}