package com.afauzi.feature_authentication.register.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afauzi.feature_authentication.register.ui.theme.TixiEventTheme

@Composable
fun RegisterScreen() {
    TixiEventTheme {
        // My Component Top App Bar
        TopAppBar {
            // Content of the screen
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 56.dp),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    // Form Component
                    FormRegister()
                    Spacer(modifier = Modifier.height(16.dp))
                    // Content Button Component
                    ContentButton()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPrev() {
    RegisterScreen()
}