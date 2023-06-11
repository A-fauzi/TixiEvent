package com.afauzi.tixievent.main.fragment_screen.map

import android.content.Context
import android.graphics.Bitmap
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import coil.compose.rememberAsyncImagePainter
import com.afauzi.tixievent.R
import com.afauzi.tixievent.util.svgConverter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MapScreen() {

    val initialZoom = 6f
    val finalZoom = 15f
    val bekasi = LatLng(-6.229834217523033, 106.96154725906443)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(bekasi, initialZoom)
    }

    LaunchedEffect(key1 = true) {
        cameraPositionState.animate(
            update = CameraUpdateFactory.newCameraPosition(
                CameraPosition(bekasi, finalZoom, 0f, 0f)
            ),
            durationMs = 1000
        )
    }
    Box(
        modifier = Modifier
            .padding(bottom = 56.dp)
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            uiSettings = MapUiSettings(zoomControlsEnabled = false)
        ) {
            val icon = bitmapDescriptorFromVector(LocalContext.current, R.drawable.card_icon_maker)
            Marker(
                state = MarkerState(position = bekasi),
                icon = icon
            )
        }

        // Card Bottom
        LazyRow(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 8.dp, end = 8.dp, bottom = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
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
                                    Icon(
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
                                Icon(
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

       Column(
           modifier = Modifier
               .padding(16.dp),
       ) {
           Row(
               modifier = Modifier.fillMaxWidth(),
               verticalAlignment = Alignment.CenterVertically
           ) {
               // Search map
               Card(
                   shape = RoundedCornerShape(16.dp)
               ) {
                   Row(
                       verticalAlignment = Alignment.CenterVertically,
                       modifier = Modifier.padding(end = 16.dp)
                   ) {
                       IconButton(onClick = { /*TODO*/ }) {
                           Icon(
                               painter = rememberAsyncImagePainter(
                                   model = R.raw.angle_small_left,
                                   svgConverter()
                               ),
                               contentDescription = null
                           )
                       }

                       Text(text = "Find for food or restaurent...")
                   }
               }

               Spacer(modifier = Modifier.weight(1f))

               // Focus Location
               Card(
                   modifier = Modifier
                       .padding(16.dp),
                   shape = RoundedCornerShape(16.dp)
               ) {
                   IconButton(onClick = {
                       // Move the camera to a new zoom level
                       cameraPositionState.move(CameraUpdateFactory.zoomIn())
                   }) {
                       Icon(
                           painter = rememberAsyncImagePainter(
                               model = R.raw.location_focus,
                               svgConverter()
                           ), contentDescription = null
                       )
                   }
               }
           }

           LazyRow(
               horizontalArrangement = Arrangement.spacedBy(4.dp)
           ) {
               items(5) {
                   Button(
                       onClick = {},
                       modifier = Modifier.padding(8.dp)
                   ) {
                       Row {
                           Icon(
                               painterResource(id = R.drawable.icon_maker_example),
                               contentDescription = "Favorite",
                               modifier = Modifier.padding(end = 4.dp),
                               tint = Color.White
                           )
                           Text(text = "Button")
                       }
                   }
               }
           }
       }
    }
}

fun bitmapDescriptorFromVector(
    context: Context,
    vectorResId: Int
): BitmapDescriptor? {

    // retrieve the actual drawable
    val drawable = ContextCompat.getDrawable(context, vectorResId) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    // draw it onto the bitmap
    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}

@Preview(showBackground = true)
@Composable
fun MapScreenPrev() {
    MapScreen()
}