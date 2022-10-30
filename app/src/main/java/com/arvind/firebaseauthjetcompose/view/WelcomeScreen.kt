package com.arvind.firebaseauthjetcompose.view

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.arvind.firebaseauthjetcompose.R
import com.arvind.firebaseauthjetcompose.component.AuthHeader
import com.arvind.firebaseauthjetcompose.navigation.ROUTE_HOME
import com.arvind.firebaseauthjetcompose.navigation.ROUTE_LOGIN
import com.arvind.firebaseauthjetcompose.navigation.ROUTE_SIGNUP
import com.arvind.firebaseauthjetcompose.ui.theme.FirebaseAuthJetComposeTheme
import com.arvind.firebaseauthjetcompose.ui.theme.Purple200
import com.arvind.firebaseauthjetcompose.ui.theme.color_Primary
import com.arvind.firebaseauthjetcompose.ui.theme.spacing
import com.arvind.firebaseauthjetcompose.utils.Resource

@Composable
fun WelcomeScreen(navController: NavController) {

    LazyColumn {
        item {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val (refHeader, refWelcomeBack, refButtonSignUp, refButtonLogin) = createRefs()
                val spacing = MaterialTheme.spacing

                Box(modifier = Modifier
                    .constrainAs(refHeader) {
                        top.linkTo(parent.top, spacing.extraLarge)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
                    .wrapContentSize()) {
                    AuthHeader()
                }

                Text(
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                        .constrainAs(refWelcomeBack) {
                            top.linkTo(refHeader.bottom, spacing.extraLarge)
                            start.linkTo(parent.start, spacing.large)
                            end.linkTo(parent.end, spacing.large)
                        },
                    text = stringResource(id = R.string.welcome_back),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
                Button(
                    onClick = {
                        navController.navigate(ROUTE_LOGIN)
                    },
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = color_Primary),
                    modifier = Modifier.constrainAs(refButtonLogin) {
                        top.linkTo(refWelcomeBack.bottom, spacing.large)
                        start.linkTo(parent.start, spacing.extraLarge)
                        end.linkTo(parent.end, spacing.extraLarge)
                        width = Dimension.fillToConstraints

                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.login),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }

                Button(
                    onClick = {
                        navController.navigate(ROUTE_SIGNUP)
                    },
                    border = BorderStroke(1.dp, Color.White),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Purple200),
                    modifier = Modifier.constrainAs(refButtonSignUp) {
                        top.linkTo(refButtonLogin.bottom, spacing.large)
                        start.linkTo(parent.start, spacing.extraLarge)
                        end.linkTo(parent.end, spacing.extraLarge)
                        width = Dimension.fillToConstraints

                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.signup),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }


            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun WelcomeScreenPreviewLight() {
    FirebaseAuthJetComposeTheme {
        WelcomeScreen(rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun WelcomeScreenPreviewDark() {
    FirebaseAuthJetComposeTheme {
        WelcomeScreen(rememberNavController())
    }
}