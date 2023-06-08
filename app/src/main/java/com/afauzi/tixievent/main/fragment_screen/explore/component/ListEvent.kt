package com.afauzi.tixievent.main.fragment_screen.explore.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.afauzi.tixievent.R
import com.afauzi.tixievent.util.svgConverter

@Composable
fun ListEvent(posterExample: Int = R.drawable.poster_event_example) {
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
                        painter = painterResource(posterExample),
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

@Preview(showBackground = true)
@Composable
fun ListEventPrev() {
    ListEvent()
}