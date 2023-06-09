package com.afauzi.tixievent.main.component

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.afauzi.tixievent.R
import com.afauzi.tixievent.search_event.SearchEventActivity
import com.afauzi.tixievent.util.svgConverter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    onQueryChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    enabled: Boolean = false,
    onClickFiltered: () -> Unit
) {
    var query by remember { mutableStateOf("") }
    val context = LocalContext.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                color = Color(0xFF6650a4)
            )
    ) {
        IconButton(
            onClick = { onSearchClick() },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Icon(
                painter = rememberAsyncImagePainter(model = R.raw.search, svgConverter()),
                contentDescription = "Search",
                tint = Color.White
            )
        }
        OutlinedTextField(
            value = query,
            onValueChange = {
                query = it
                onQueryChange(it)
            },
            modifier = Modifier
                .weight(1f)
                .clickable {
                    context.startActivity(Intent(context, SearchEventActivity::class.java))
                },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            singleLine = true,
            placeholder = {
                Text(text = "| Search...", color = Color.White.copy(alpha = 0.6f))
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xFF6650a4),
                focusedBorderColor = Color(0xFF6650a4),
                textColor = Color.White
            ),
            enabled = enabled
        )
        ChipWithIconAndText(
            icon = rememberAsyncImagePainter(
                model = R.raw.bars_filter,
                svgConverter()
            ),
            text = "Filters",
            onClick = {
                onClickFiltered()
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SearchViewPrev() {
    SearchView({}, {}, onClickFiltered = {})
}