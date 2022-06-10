package com.kanyideveloper.joomia.feature_auth.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.kanyideveloper.joomia.R
import com.kanyideveloper.joomia.core.util.Constants.SPLASH_SCREEN_DURATION
import com.kanyideveloper.joomia.feature_auth.presentation.destinations.AuthDashboardScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Destination(start = true)
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val scale = remember {
            Animatable(0f)
        }

        val overshootInterpolator = remember {
            OvershootInterpolator(1.5f)
        }

        LaunchedEffect(key1 = true) {
            withContext(Dispatchers.Main) {
                scale.animateTo(
                    targetValue = 1.0f,
                    animationSpec = tween(
                        durationMillis = 1000,
                        easing = {
                            overshootInterpolator.getInterpolation(it)
                        })
                )

                delay(SPLASH_SCREEN_DURATION)
                navigator.popBackStack()
                navigator.navigate(AuthDashboardScreenDestination)
            }
        }
        Image(painter = painterResource(id = R.drawable.ic_joomia_logo), contentDescription = null)
    }
}