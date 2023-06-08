package com.afauzi.tixievent.main.fragment_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import com.afauzi.tixievent.R
import com.afauzi.tixievent.navigation_drawer.DrawerFooter
import com.afauzi.tixievent.navigation_drawer.DrawerHeader
import com.afauzi.tixievent.navigation_drawer.DrawerItem
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen() {
    val context = LocalContext.current

    // State untuk mengontrol status buka/tutup drawer
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(280.dp)
                        .background(Color.White)
                ) {
                    // Drawer header
                    DrawerHeader(coroutineScope, drawerState)
                    // Drawer items
                    DrawerItem(
                        title = "My Profile",
                        iconRes = R.raw.user
                    ) { Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show() }
                    DrawerItem(
                        title = "Message",
                        iconRes = R.raw.message
                    ) { Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show() }

                    DrawerItem(
                        title = "Calender",
                        iconRes = R.raw.calendar
                    ) { Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show() }

                    DrawerItem(
                        title = "Bookmark",
                        iconRes = R.raw.bookmark
                    ) { Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show() }

                    DrawerItem(
                        title = "Contact Us",
                        iconRes = R.raw.contact_us
                    ) { Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show() }

                    DrawerItem(
                        title = "Settings",
                        iconRes = R.raw.settings
                    ) { Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show() }

                    DrawerItem(
                        title = "Helps & FAQs",
                        iconRes = R.raw.help
                    ) { Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show() }

                    DrawerItem(
                        title = "Sign Out",
                        iconRes = R.raw.sign_out
                    ) { Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show() }

                    // Footer
                    DrawerFooter()

                }
            }
        },
        content = {
            Column {
                TopAppBar(
                    title = { Text(text = "Akhmad Fauzi") },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
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
                // Content of the screen goes here
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                ) {
                    // Content Screen
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(bottom = 56.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        )
                        {
                            Text(text = "Upcoming Events")
                            Text(text = "Se all")
                        }

                        val itemEvent = listOf(
                            "International Event Music",
                            "International Event Sport",
                            "International Event Food"
                        )
                        LazyRow {
                            items(itemEvent) { item ->
                                Card(
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.poster_event_example_2),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(
                                                    width = 250.dp,
                                                    height = 150.dp
                                                )
                                                .clip(RoundedCornerShape(8.dp))
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(text = item)
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Row(modifier = Modifier.fillMaxWidth()) {
                                            Box(
                                                modifier = Modifier.padding(
                                                    start = 0.dp,
                                                    end = 16.dp
                                                )
                                            ) {
                                                Box(modifier = Modifier.offset(x = 24.dp)) {
                                                    Image(
                                                        painter = painterResource(R.drawable.photo_profile_example),
                                                        contentDescription = "Image 1",
                                                        modifier = Modifier
                                                            .size(16.dp)
                                                            .clip(CircleShape),
                                                        contentScale = ContentScale.Crop
                                                    )
                                                }
                                                Box(modifier = Modifier.offset(x = 12.dp)) {
                                                    Image(
                                                        painter = painterResource(R.drawable.person_example_1),
                                                        contentDescription = "Image 2",
                                                        modifier = Modifier
                                                            .size(16.dp)
                                                            .clip(CircleShape),
                                                        contentScale = ContentScale.Crop
                                                    )
                                                }

                                                Box {
                                                    Image(
                                                        painter = painterResource(R.drawable.person_example_2),
                                                        contentDescription = "Image 2",
                                                        modifier = Modifier
                                                            .size(16.dp)
                                                            .clip(CircleShape),
                                                        contentScale = ContentScale.Crop
                                                    )
                                                }
                                            }
                                            Spacer(modifier = Modifier.width(16.dp))
                                            Text(
                                                text = "+20 Going",
                                                color = Color.Blue,
                                                fontSize = 12.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Row {
                                            Icon(
                                                painter = rememberAsyncImagePainter(
                                                    model = R.raw.map_filled,
                                                    svgConverter()
                                                ),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .size(12.dp)
                                                    .align(Alignment.CenterVertically)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(
                                                text = "Gelora Bung Karno, Jakarta",
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(text = "Invite your friends")
                                    Text(text = "Get $20 for ticket")
                                    Button(onClick = { /*TODO*/ }) {
                                        Text(text = "Invite")
                                    }
                                }
                                Image(
                                    painter = painterResource(id = R.drawable.gift_example),
                                    contentDescription = null
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        )
                        {
                            Text(text = "Nearby You ")
                            Text(text = "Se all")
                        }
                        LazyRow {
                            items(itemEvent) { item ->
                                Card(
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.poster_event_example),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(
                                                    width = 250.dp,
                                                    height = 150.dp
                                                )
                                                .clip(RoundedCornerShape(8.dp))
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(text = item)
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Row(modifier = Modifier.fillMaxWidth()) {
                                            Box(
                                                modifier = Modifier.padding(
                                                    start = 0.dp,
                                                    end = 16.dp
                                                )
                                            ) {
                                                Box(modifier = Modifier.offset(x = 24.dp)) {
                                                    Image(
                                                        painter = painterResource(R.drawable.photo_profile_example),
                                                        contentDescription = "Image 1",
                                                        modifier = Modifier
                                                            .size(16.dp)
                                                            .clip(CircleShape),
                                                        contentScale = ContentScale.Crop
                                                    )
                                                }
                                                Box(modifier = Modifier.offset(x = 12.dp)) {
                                                    Image(
                                                        painter = painterResource(R.drawable.person_example_1),
                                                        contentDescription = "Image 2",
                                                        modifier = Modifier
                                                            .size(16.dp)
                                                            .clip(CircleShape),
                                                        contentScale = ContentScale.Crop
                                                    )
                                                }

                                                Box {
                                                    Image(
                                                        painter = painterResource(R.drawable.person_example_2),
                                                        contentDescription = "Image 2",
                                                        modifier = Modifier
                                                            .size(16.dp)
                                                            .clip(CircleShape),
                                                        contentScale = ContentScale.Crop
                                                    )
                                                }
                                            }
                                            Spacer(modifier = Modifier.width(16.dp))
                                            Text(
                                                text = "+20 Going",
                                                color = Color.Blue,
                                                fontSize = 12.sp
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Row {
                                            Icon(
                                                painter = rememberAsyncImagePainter(
                                                    model = R.raw.map_filled,
                                                    svgConverter()
                                                ),
                                                contentDescription = null,
                                                modifier = Modifier
                                                    .size(12.dp)
                                                    .align(Alignment.CenterVertically)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(
                                                text = "Gelora Bung Karno, Jakarta",
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerHeader(coroutineScope: CoroutineScope, drawerState: DrawerState) {
    // Draw your drawer header here
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.photo_profile_example),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        drawerState.close()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close Drawer"
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Akhmad Fauzi",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
private fun svgConverter(): ImageLoader {
    return ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()
}

@Composable
fun DrawerItem(title: String, iconRes: Int, clickLable: () -> Unit) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Icon(
            painter = rememberAsyncImagePainter(iconRes, svgConverter()),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        ClickableText(
            text = AnnotatedString(title),
            onClick = { clickLable() },
            style = TextStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}

@Composable
fun DrawerFooter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "Upgrade To Pro",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Color.Cyan
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ExploreScreenPrev() {
    ExploreScreen()
}