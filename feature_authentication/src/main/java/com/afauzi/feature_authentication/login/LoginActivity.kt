package com.afauzi.feature_authentication.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.afauzi.feature_authentication.login.ui.component.LoginScreen

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginScreen()
}