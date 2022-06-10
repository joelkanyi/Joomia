package com.kanyideveloper.joomia.feature_auth.presentation.auth_dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.kanyideveloper.joomia.R
import com.kanyideveloper.joomia.core.presentation.ui.theme.MainWhiteColor
import com.kanyideveloper.joomia.core.presentation.ui.theme.YellowMain
import com.kanyideveloper.joomia.feature_auth.presentation.destinations.LoginScreenDestination
import com.kanyideveloper.joomia.feature_auth.presentation.destinations.RegisterScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlin.system.exitProcess

@OptIn(ExperimentalComposeUiApi::class)
@Destination
@Composable
fun AuthDashboardScreen(
    navigator: DestinationsNavigator
) {
    Dialog(
        onDismissRequest = {
            exitProcess(0)
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ) {
        Column {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.banner_image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 24.dp),
                        color = YellowMain,
                        fontSize = 24.sp,
                        text = "Make your shopping enjoyable with us"
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = {
                            navigator.navigate(LoginScreenDestination)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                        shape = RoundedCornerShape(8)

                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            text = "Sign In"
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    OutlinedButton(
                        onClick = {
                            navigator.navigate(RegisterScreenDestination)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = MainWhiteColor,
                            backgroundColor = Color.Transparent,
                        ),
                        border = BorderStroke(1.dp, MainWhiteColor),
                        shape = RoundedCornerShape(8)
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            text = "Sign Up"
                        )
                    }
                    Spacer(modifier = Modifier.height(42.dp))
                }
            }
        }
    }
}