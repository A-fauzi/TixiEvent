package com.afauzi.tixievent.bottom_sheet

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.afauzi.tixievent.R
import com.afauzi.tixievent.main.component.SearchView
import com.afauzi.tixievent.ui.theme.TixiEventTheme
import com.afauzi.tixievent.util.svgConverter
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterScreenBottomSheet(
    modifier: Modifier = Modifier,
    topAppBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {},
    searchEnabled: Boolean = false
) {
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    )

    val roundedCornerRadius = 0.dp

    BackHandler(modalSheetState.isVisible) {
        coroutineScope.launch { modalSheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(
            topStart = roundedCornerRadius,
            topEnd = roundedCornerRadius
        ),
        sheetContent = {
            // Content in bottomsheet
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(text = "Filter", fontSize = 24.sp)
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    val titleCategory = listOf("Sport", "Music", "Art", "Food", "Religious")
                    items(titleCategory) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            var colorState by remember { mutableStateOf(false) }
                            val backgroundColor = if (colorState) Color.Blue else Color.White
                            val tintIcon = if (colorState) Color.White else Color.Black

                            Card(
                                shape = RoundedCornerShape(24.dp),
                                border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.7f)),
                                elevation = 0.dp,
                                modifier = Modifier.clickable {
                                    colorState = !colorState
                                },
                                backgroundColor = backgroundColor
                            ){
                                Icon(
                                    painter = rememberAsyncImagePainter(
                                        model = R.raw.bell,
                                        svgConverter()
                                    ), contentDescription = null,
                                    modifier = Modifier.padding(16.dp),
                                    tint = tintIcon
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = it)
                        }
                    }
                }

            }
        }
    ) {
        Column(
            modifier = modifier
        ) {
            TixiEventTheme {
                topAppBar()
                SearchView(onQueryChange = {}, onSearchClick = { /*TODO*/ }, onClickFiltered = {
                    coroutineScope.launch {
                        if (modalSheetState.isVisible)
                            modalSheetState.hide()
                        else
                            modalSheetState.show()
                    }
                }, enabled = searchEnabled)
                content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenBottomSheetPrev() {
    FilterScreenBottomSheet()
}