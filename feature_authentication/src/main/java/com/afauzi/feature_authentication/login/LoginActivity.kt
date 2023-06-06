package com.afauzi.feature_authentication.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afauzi.feature_authentication.R
import com.afauzi.feature_authentication.login.ui.theme.TixiEventTheme
import com.afauzi.feature_authentication.register.RegisterActivity

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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

                // Text sing in
                Text(text = "Sign In")
                Spacer(modifier = Modifier.height(16.dp))
                // Form
                Column(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    var textEmail by remember { mutableStateOf(TextFieldValue("")) }
                    var textPassword by remember { mutableStateOf(TextFieldValue("")) }
                    var passwordVisible by remember { mutableStateOf(false) }
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = textEmail,
                        onValueChange = { newText ->
                            textEmail = newText
                        },
                        label = {
                            Text(text = "Email")
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        singleLine = true,
                        placeholder = { Text(text = "Input Email") },
                        shape = RoundedCornerShape(percent = 20),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = textPassword,
                        onValueChange = { newText ->
                            textPassword = newText
                        },
                        label = {
                            Text(text = "Password")
                        },
                        trailingIcon = {
                            if (passwordVisible) {
                                IconButton(onClick = { passwordVisible = false }) {
                                    Icon(
                                        Icons.Outlined.VisibilityOff,
                                        contentDescription = "show_password"
                                    )
                                }
                            } else {
                                IconButton(
                                    onClick = { passwordVisible = true }) {
                                    Icon(
                                        Icons.Outlined.Visibility,
                                        contentDescription = "hide_password"
                                    )
                                }
                            }
                        },
                        visualTransformation = if (passwordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        placeholder = { Text(text = "Input Password") },
                        shape = RoundedCornerShape(percent = 20),
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                // remember me
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val switchState = remember { mutableStateOf(false) }
                    Switch(
                        checked = switchState.value,
                        onCheckedChange = { checked ->
                            switchState.value = checked
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Remember Me")
                    Text(
                        text = "Forgot Password",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.End,
                    )
                }

               Column(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center
               ) {
                   // Button
                   Button(
                       onClick = { /*TODO*/ },
                       modifier = Modifier.align(Alignment.CenterHorizontally)
                   ) {
                       Text(text = "Sign In")
                   }
                   Spacer(modifier = Modifier.height(16.dp))
                   // Text Or
                   Text(text = "Or")
                   Spacer(modifier = Modifier.height(16.dp))
                   Button(
                       onClick = { /* Button action */ }
                   ) {
                       Row(verticalAlignment = Alignment.CenterVertically) {
                           Icon(
                               painter = painterResource(id = R.drawable.icons_google),
                               contentDescription = "Icon",
                               modifier = Modifier.padding(end = 4.dp)
                           )
                           Text(text = "Login With Google")
                       }
                   }
                   Button(
                       onClick = { /* Button action */ }
                   ) {
                       Row(verticalAlignment = Alignment.CenterVertically) {
                           Icon(
                               painter = painterResource(id = R.drawable.icons_facebook),
                               contentDescription = "Icon",
                               modifier = Modifier.padding(end = 4.dp)
                           )
                           Text(text = "Login With Facebook")
                       }
                   }
                   Spacer(modifier = Modifier.height(16.dp))
                   Row {
                       Text(text = "Don't have an account?")
                       Spacer(modifier = Modifier.width(4.dp))
                       Text(
                           text = "Sign Up",
                           color = Color.Blue,
                           modifier = Modifier.clickable {
                               context.startActivity(Intent(context, RegisterActivity::class.java))
                           }
                       )
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