package com.afauzi.feature_authentication.login.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afauzi.feature_authentication.R
import com.afauzi.feature_authentication.login.ui.theme.TixiEventTheme

@Composable
fun LoginScreen() {
    TixiEventTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Logo
                Image(
                    painterResource(id = R.drawable.logo_example),
                    contentDescription = "",
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.CenterHorizontally)
                )


                // Form
                FormLogin()

                Spacer(modifier = Modifier.height(16.dp))
                // remember me
                RememberMe()

                // Content Button
                ContentButton()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPrev() {
    LoginScreen()
}