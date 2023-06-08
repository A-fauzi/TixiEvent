package com.afauzi.tixievent.main.fragment_screen.explore.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afauzi.tixievent.R

data class CustomData(val title: String, val imageRes: Int)

@Composable
fun Category() {
    val dataExample = listOf(
        CustomData("Sport", R.drawable.sport_example),
        CustomData("Music", R.drawable.concert_example),
        CustomData("Food", R.drawable.food_example),
        CustomData("Religious", R.drawable.religious_example),
    )
    Column {
        Text(text = "Categories")
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {
            items(dataExample) { item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = item.imageRes),
                        contentDescription = null,
                        modifier = Modifier.clip(
                            CircleShape
                        )
                            .size(100.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = item.title)
                }
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryPrev() {
    Category()
}