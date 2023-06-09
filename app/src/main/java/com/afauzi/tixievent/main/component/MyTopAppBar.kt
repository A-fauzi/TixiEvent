package com.afauzi.tixievent.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.afauzi.tixievent.R
import com.afauzi.tixievent.util.svgConverter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    navigationIcon: @Composable () -> Unit = {},
    title: @Composable () -> Unit = {},
    actions: @Composable () -> Unit = {}
) {

    CenterAlignedTopAppBar(
        title = {
            title()
        },
        navigationIcon = {
          navigationIcon()
        },
        actions = {
            actions()
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF6650a4))
    )
}
@Composable
fun ChipWithIconAndText(icon: Painter, text: String) {
    Box(
        modifier = Modifier.padding(8.dp),
        contentAlignment = Alignment.CenterStart,
    ) {
        Box(
            modifier = Modifier
                .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(50.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            content = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    content = {
                        Box(
                            modifier = Modifier
                                .background(Color.White.copy(alpha = 0.2f), CircleShape)
                                .size(32.dp),
                            content = {
                                IconButton(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier.align(Alignment.Center)
                                ) {
                                    Icon(
                                        painter = icon,
                                        contentDescription = "Icon",
                                        tint = Color.White,
                                        modifier = Modifier
                                            .size(16.dp)
                                    )
                                }
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = text,
                            color = Color.White,
                            style = TextStyle(fontSize = 16.sp)
                        )
                    }
                )
            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyTopAppBarPrev() {
    MyTopAppBar()
}