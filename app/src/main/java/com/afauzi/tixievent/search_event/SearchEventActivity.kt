package com.afauzi.tixievent.search_event

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.afauzi.tixievent.R
import com.afauzi.tixievent.main.component.MyTopAppBar
import com.afauzi.tixievent.main.component.SearchView
import com.afauzi.tixievent.search_event.ui.theme.TixiEventTheme
import com.afauzi.tixievent.util.svgConverter

class SearchEventActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchEventApp()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchEventApp() {
    TixiEventTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            MyTopAppBar(
                {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = rememberAsyncImagePainter(model = R.raw.arrow_left, svgConverter()),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                {
                    Text(text = "Search", color = Color.White)
                }
            )

            SearchView(onQueryChange = {}, onSearchClick = { /*TODO*/ }, enabled = true)

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(5) {
                    Card(
                        modifier = Modifier
                            .size(width = 350.dp, height = 150.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.poster_event_example),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(width = 100.dp, height = 150.dp)
                                    .clip(RoundedCornerShape(16.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Wed, Apr 28 - 5:30'PM",
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                    IconButton(onClick = { /*TODO*/ }) {
                                        androidx.compose.material.Icon(
                                            painter = rememberAsyncImagePainter(
                                                model = R.raw.bookmark_filled,
                                                svgConverter()
                                            ),
                                            contentDescription = null,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                SelectionContainer {
                                    Text(
                                        text = "Jo Malone London's Mother's Day Presents Jo Malone London's Mother's Day Presents Jo Malone London's Mother's Day Presents Jo Malone London's Mother's Day Presents ",
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 16.sp
                                        ),
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    androidx.compose.material.Icon(
                                        painter = rememberAsyncImagePainter(
                                            model = R.raw.map_filled,
                                            svgConverter()
                                        ),
                                        contentDescription = null,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    SelectionContainer {
                                        Text(
                                            text = "Radius Gallery - Santa Cruz, CA",
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
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
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    SearchEventApp()
}