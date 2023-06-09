package com.afauzi.feature_authentication.reset_password

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.afauzi.feature_authentication.reset_password.component.ResetPasswordScreen

class ResetPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResetPasswordScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPassActivityPrev() {
    ResetPasswordScreen()
}