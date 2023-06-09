package com.afauzi.tixievent.main.fragment_screen.explore.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afauzi.tixievent.R

@Composable
fun PeopleGoing(îmageSize: Dp = 16.dp, textSize: TextUnit = 12.sp) {
    Row {
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
                        .size(îmageSize)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Box(modifier = Modifier.offset(x = 12.dp)) {
                Image(
                    painter = painterResource(R.drawable.person_example_1),
                    contentDescription = "Image 2",
                    modifier = Modifier
                        .size(îmageSize)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Box {
                Image(
                    painter = painterResource(R.drawable.person_example_2),
                    contentDescription = "Image 2",
                    modifier = Modifier
                        .size(îmageSize)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "+20 Going",
            color = Color.Blue,
            fontSize = textSize
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PeopleGoingPrev() {
    PeopleGoing()
}