package com.afauzi.feature_authentication.register

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afauzi.feature_authentication.register.ui.component.ContentButton
import com.afauzi.feature_authentication.register.ui.component.FormRegister
import com.afauzi.feature_authentication.register.ui.component.RegisterScreen
import com.afauzi.feature_authentication.register.ui.component.TopAppBar
import com.afauzi.feature_authentication.register.ui.theme.TixiEventTheme

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