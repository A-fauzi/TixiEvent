package com.afauzi.tixievent.main.fragment_screen.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.afauzi.tixievent.bottom_sheet.FilterScreenBottomSheet
import com.afauzi.tixievent.main.component.NavigationDrawer
import com.afauzi.tixievent.main.component.SearchView
import com.afauzi.tixievent.main.fragment_screen.explore.component.Category
import com.afauzi.tixievent.main.fragment_screen.explore.component.ListEvent
import com.afauzi.tixievent.util.svgConverter

@Composable
fun ExploreScreen() {
    FilterScreenBottomSheet(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(bottom = 56.dp),
        content = {
            Column(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))

                // Category
                Category()

                Spacer(modifier = Modifier.height(8.dp))

                // Feature List Up Coming Event
                ListEvent()

                Spacer(modifier = Modifier.height(8.dp))

                // Invitation
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

                // Feature List Nearby Event
                ListEvent(R.drawable.poster_event_example_2, "Nearby You")
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun ExploreScreenPrev() {
    ExploreScreen()
}