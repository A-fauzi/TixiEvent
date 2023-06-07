package com.afauzi.tixievent.verify_otp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.afauzi.tixievent.verify_otp.component.VerifyOtpScreen

class VerifyOtpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerifyOtpScreen()
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    VerifyOtpScreen()
}