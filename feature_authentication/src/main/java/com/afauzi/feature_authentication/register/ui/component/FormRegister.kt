package com.afauzi.feature_authentication.register.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormRegister() {
    Column {
        var textFullName by remember { mutableStateOf(TextFieldValue("")) }
        var textEmail by remember { mutableStateOf(TextFieldValue("")) }
        var textPassword by remember { mutableStateOf(TextFieldValue("")) }
        var textConfirmPassword by remember { mutableStateOf(TextFieldValue("")) }
        var passwordVisible by remember { mutableStateOf(false) }
        var confirmPasswordVisible by remember { mutableStateOf(false) }

        // Text sing up
        Text(text = "Sign Up")
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = textFullName,
            onValueChange = { newText ->
                textFullName = newText
            },
            label = {
                Text(text = "Full name")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            placeholder = { Text(text = "Input Fullname") },
            shape = RoundedCornerShape(percent = 20),
        )
        Spacer(modifier = Modifier.height(16.dp))
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
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = textConfirmPassword,
            onValueChange = { newText ->
                textConfirmPassword = newText
            },
            label = {
                Text(text = "Confirm Password")
            },
            trailingIcon = {
                if (confirmPasswordVisible) {
                    IconButton(onClick = { confirmPasswordVisible = false }) {
                        Icon(
                            Icons.Outlined.VisibilityOff,
                            contentDescription = "show_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { confirmPasswordVisible = true }) {
                        Icon(
                            Icons.Outlined.Visibility,
                            contentDescription = "hide_password"
                        )
                    }
                }
            },
            visualTransformation = if (confirmPasswordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            placeholder = { Text(text = "Input Confirm Password") },
            shape = RoundedCornerShape(percent = 20),
        )

    }
}

@Preview(showBackground = true)
@Composable
fun FormSignUpPrev(){
    FormRegister()
}