package com.afauzi.tixievent.main.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.afauzi.tixievent.R
import com.afauzi.tixievent.main.fragment_screen.add_event.AddEventScreen
import com.afauzi.tixievent.main.fragment_screen.event.EventScreen
import com.afauzi.tixievent.main.fragment_screen.explore.ExploreScreen
import com.afauzi.tixievent.main.fragment_screen.map.MapScreen
import com.afauzi.tixievent.main.fragment_screen.profile.ProfileScreen

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {
    object Explore : BottomNavItem("Explore", R.raw.explore_filled, "explore")
    object Event : BottomNavItem("Event", R.raw.calender_filled, "event")
    object AddEvent : BottomNavItem("AddEvent", R.raw.add_event, "addEvent")
    object Map : BottomNavItem("Map", R.raw.map_filled, "map")
    object Profile : BottomNavItem("Profile", R.raw.user_filled, "profile")
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

    androidx.compose.material.BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
        contentColor = Color.White
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
                        painter = rememberAsyncImagePainter(model = item.icon, imageLoader),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
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

@Preview(showBackground = true)
@Composable
fun BottomNavigationPrev() {
    BottomNavigation(navController = rememberNavController())
}