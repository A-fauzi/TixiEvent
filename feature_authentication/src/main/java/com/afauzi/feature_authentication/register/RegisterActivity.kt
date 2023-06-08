package com.afauzi.feature_authentication.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.afauzi.feature_authentication.register.ui.component.RegisterScreen

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           RegisterScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    RegisterScreen()
}