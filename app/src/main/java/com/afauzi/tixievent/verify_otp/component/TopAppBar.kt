package com.afauzi.tixievent.verify_otp.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(content: @Composable () -> Unit) {
    Scaffold(
        topBar = {
            androidx.compose.material3.TopAppBar(
                title = { Text(text = "App Title") },
                navigationIcon = {
                    IconButton(
                        onClick = { /* Handle back button click */ }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPrev(){
    TopAppBar{}
}