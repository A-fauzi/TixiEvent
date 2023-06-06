package com.afauzi.feature_authentication.login.ui.component

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afauzi.feature_authentication.R
import com.afauzi.feature_authentication.register.RegisterActivity

@Composable
fun ContentButton() {
    val context = LocalContext.current
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

@Preview(showBackground = true)
@Composable
fun ContentButtonPreview() {
    ContentButton()
}