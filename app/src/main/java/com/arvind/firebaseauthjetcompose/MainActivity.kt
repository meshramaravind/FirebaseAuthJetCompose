package com.arvind.firebaseauthjetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.arvind.firebaseauthjetcompose.navigation.AppNavHost
import com.arvind.firebaseauthjetcompose.ui.theme.FirebaseAuthJetComposeTheme
import com.arvind.firebaseauthjetcompose.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseAuthJetComposeTheme {
                AppNavHost(viewModel)
            }
        }
    }
}
