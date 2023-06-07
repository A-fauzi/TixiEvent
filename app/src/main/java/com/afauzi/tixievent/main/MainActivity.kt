package com.afauzi.tixievent.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afauzi.feature_authentication.login.LoginActivity
import com.afauzi.feature_authentication.register.RegisterActivity
import com.afauzi.feature_authentication.reset_password.ResetPasswordActivity
import com.afauzi.tixievent.verify_otp.VerifyOtpActivity
import com.afauzi.tixievent.ui.theme.TixiEventTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val context = LocalContext.current
    TixiEventTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                for (i in 0..6) {
                    when (i) {
                        0 -> Button(onClick = {
                            context.startActivity(Intent(context, LoginActivity::class.java))
                        }) {
                            Text(text = "Login")
                        }

                        1 -> Button(onClick = {
                            context.startActivity(Intent(context, RegisterActivity::class.java))
                        }) {
                            Text(text = "Register")
                        }

                        2 -> Button(onClick = {
                            Toast.makeText(context, "Event", Toast.LENGTH_SHORT).show()
                        }) {
                            Text(text = "Event")
                        }

                        3 -> Button(onClick = {
                            Toast.makeText(context, "Ticket Clicked", Toast.LENGTH_SHORT).show()
                        }) {
                            Text(text = "Ticket")
                        }

                        4 -> Button(onClick = {
                            Toast.makeText(context, "Transaction Clicked", Toast.LENGTH_SHORT)
                                .show()
                        }) {
                            Text(text = "Transaction")
                        }
                        5 -> Button(onClick = {
                            context.startActivity(Intent(context, VerifyOtpActivity::class.java))
                        }) {
                            Text(text = "Otp Verify")
                        }
                        6 -> Button(onClick = {
                            context.startActivity(Intent(context, ResetPasswordActivity::class.java))
                        }) {
                            Text(text = "Reset Password")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App()
}