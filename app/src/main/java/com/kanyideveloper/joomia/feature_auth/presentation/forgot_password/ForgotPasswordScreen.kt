package com.kanyideveloper.joomia.feature_auth.presentation.forgot_password

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun ForgotPasswordScreen() {
    Scaffold(
        topBar = {
            Column(Modifier.padding(16.dp)) {
                Text(text = "Forgot Password", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "Please enter an email address that you had registered with, so that we can send you a password reset link",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(64.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {

                },
                label = {
                    Text(text = "Email")
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Email,
                ),
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {

                },
                shape = RoundedCornerShape(8)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp), text = "Continue", textAlign = TextAlign.Center
                )
            }
        }
    }
}