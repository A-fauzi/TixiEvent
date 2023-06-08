package com.afauzi.tixievent.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.afauzi.tixievent.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(drawerState: DrawerState? = null , coroutineScope: CoroutineScope? = null) {
    TopAppBar(
        title = { Text(text = "Akhmad Fauzi") },
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope?.launch {
                    drawerState?.open()
                }
            }) {
                Image(
                    modifier = Modifier.clip(CircleShape),
                    painter = painterResource(id = R.drawable.photo_profile_example),
                    contentDescription = "Menu",
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyTopAppBarPrev() {
    MyTopAppBar()
}