package com.kanyideveloper.joomia.feature_auth.presentation.login

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kanyideveloper.joomia.core.presentation.ui.theme.YellowMain
import com.kanyideveloper.joomia.core.presentation.ui.theme.poppins
import com.kanyideveloper.joomia.feature_auth.presentation.destinations.ForgotPasswordScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
) {
    Scaffold(
        topBar = {
            Column(Modifier.padding(16.dp)) {
                Text(text = "Welcome Back", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "Login to your account to continue shopping",
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

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {

                },
                label = {
                    Text(text = "Password")
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Password,
                ),
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = false, onCheckedChange = {})
                    Text(text = "Remember me", fontSize = 12.sp)
                }
                TextButton(onClick = {
                    navigator.navigate(ForgotPasswordScreenDestination)
                }) {
                    Text(text = "Forgot password?")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {

                },
                shape = RoundedCornerShape(8)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp), text = "Sign In", textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            TextButton(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Don't have an account?")
                        append(" ")
                        withStyle(
                            style = SpanStyle(color = YellowMain, fontWeight = FontWeight.Bold)
                        ) {
                            append("Sign Up")
                        }
                    },
                    fontFamily = poppins,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}