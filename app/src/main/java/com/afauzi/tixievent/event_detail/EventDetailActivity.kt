package com.afauzi.tixievent.event_detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.view.WindowCompat
import coil.compose.rememberAsyncImagePainter
import com.afauzi.tixievent.R
import com.afauzi.tixievent.main.component.MyTopAppBar
import com.afauzi.tixievent.main.fragment_screen.explore.component.PeopleGoing
import com.afauzi.tixievent.ui.theme.TixiEventTheme
import com.afauzi.tixievent.util.svgConverter
import kotlinx.coroutines.launch

class EventDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            EventDetailApp()
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun EventDetailApp() {

    TixiEventTheme {
        CollapsingToolbarWithTopAppBar()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollapsingToolbarWithTopAppBar() {

    // Creating a Simple Scaffold
    // Layout for the application
    Scaffold(
        // Creating a Top Bar
        topBar = {
            MyTopAppBar(
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            painter = rememberAsyncImagePainter(model = R.raw.arrow_left, svgConverter()),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                title = {
                    Text(text = "Event Detail", color = Color.White)
                },
                actions = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            modifier = Modifier
                                .size(16.dp),
                            painter = rememberAsyncImagePainter(model = R.raw.bookmark_filled, svgConverter()),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            )
        },

        // Creating content
        content = {

            // Creating a Column Layout
            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val lazyListState = rememberLazyListState()
                    var scrolledY = 0f
                    var previousOffset = 0
                    LazyColumn(
                        Modifier.fillMaxSize(),
                        lazyListState,
                    ) {

                        // Setting the Image as the first
                        // item and making it collapsible
                        item {

                            Box(
                                modifier = Modifier
                                    .graphicsLayer {
                                        scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                        translationY = scrolledY * 0.5f
                                        previousOffset = lazyListState.firstVisibleItemScrollOffset
                                    }
                                    .zIndex(1f)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.poster_event_example),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillWidth,
                                    modifier = Modifier
                                        .height(350.dp)
                                        .fillMaxWidth()
                                )

                                Card(
                                    modifier = Modifier
                                        .align(Alignment.BottomCenter)
                                        .padding(horizontal = 50.dp),
                                    shape = RoundedCornerShape(24.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        // People Going
                                        PeopleGoing(32.dp, 16.sp)
                                        Spacer(modifier = Modifier.weight(1f))
                                        // Button
                                        Button(onClick = { /*TODO*/ }) {
                                            Text(text = "Invite")
                                        }
                                    }
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp, 16.dp, 16.dp, 56.dp)
                            ) {
                                // Title
                                Text(
                                    text = "International Band Music Concert",
                                    style = TextStyle(
                                        fontSize = 32.sp,
                                        fontFamily = FontFamily.SansSerif
                                    )
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                // Calender
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            painter = rememberAsyncImagePainter(
                                                model = R.raw.calender_filled,
                                                svgConverter()
                                            ),
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Column {
                                        Text(text = "14 December, 2021")
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(text = "Tuesday, 4:00PM - 9:00PM")
                                    }
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                // Map
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            painter = rememberAsyncImagePainter(
                                                model = R.raw.map_filled,
                                                svgConverter()
                                            ),
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Column {
                                        Text(text = "Gala Convention Center")
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(text = "36 Guild Street London, UK")
                                    }
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                // Organization
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Image(
                                            painter = painterResource(id = R.drawable.photo_profile_example),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(50.dp)
                                                .clip(RoundedCornerShape(12.dp))
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Column {
                                        Text(text = "Akhmad Fauzi")
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(text = "Organization")
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Button(onClick = { /*TODO*/ }) {
                                        Text(text = "Follow")
                                    }
                                }

                                // About
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(text = "About Event")
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(text = "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.")
                                Text(text = "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before final copy is available.")

                            }
                        }
                    }
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Text(text = "Buy Ticket $120")
                }
            }
        }
    )
}