package com.afauzi.tixievent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afauzi.tixievent.ui.theme.TixiEventTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class VerifyOtpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppOtp()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppOtp() {
    val focusRequesters = List(4) { remember { FocusRequester() } }

    // Declare the mutable states for otpOne, otpTwo, otpThree, and otpFour
    val otps = List(4) { remember { mutableStateOf("") } }

    TixiEventTheme {
        Scaffold(
            topBar = {
                TopAppBar(
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
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 56.dp),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(text = "Verification", fontSize = 24.sp)
                    Text(text = "We've send you the verification")
                    Text(text = "code on +62 821 1296 6360")
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, start = 15.dp, end = 15.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        otps.forEachIndexed { index, otp ->
                            CommonOtpTextField(otp = otp, focusRequester = focusRequesters[index]) {
                                if (index < otps.lastIndex) {
                                    otps[index + 1].value = ""
                                    focusRequesters[index + 1].requestFocus()
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Continue")
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    val remainingTime = remember { mutableStateOf(120) }
                    LaunchedEffect(Unit) {
                        withContext(Dispatchers.Default) {
                            while (remainingTime.value > 0) {
                                delay(1000)
                                remainingTime.value -= 1
                            }
                        }
                    }
                    Text(
                        text = "Re-send code in ${formatTime(remainingTime.value)}",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

    }
}

private fun formatTime(time: Int): String {
    val minutes = time / 60
    val seconds = time % 60
    return "%02d:%02d".format(minutes, seconds)
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CommonOtpTextField(
    otp: MutableState<String>,
    focusRequester: FocusRequester,
    onNext: () -> Unit
) {
    val max = 1
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = otp.value,
        singleLine = true,
        onValueChange = { if (it.length <= max) otp.value = it },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                onNext()
                keyboardController?.show()
            }
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .width(60.dp)
            .height(60.dp)
            .focusRequester(focusRequester),
        maxLines = 1,
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Center
        )
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    AppOtp()
}