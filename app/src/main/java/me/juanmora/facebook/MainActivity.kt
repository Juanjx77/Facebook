package me.juanmora.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.juanmora.facebook.ui.screens.FacebookLoginScreen
import me.juanmora.facebook.ui.screens.FacebookRegisterScreen
import me.juanmora.facebook.ui.screens.FeedScreen
import me.juanmora.facebook.ui.screens.PaswdScreen
import me.juanmora.facebook.ui.theme.FacebookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FacebookTheme {
                val myNavController = rememberNavController()
                NavHost(
                    navController = myNavController,
                    startDestination = "login",
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(route = "login") {
                        FacebookLoginScreen(
                            onClickRegister = {
                                myNavController.navigate(route = "register")
                            },
                            onClickIniciarSesion = {
                                myNavController.navigate(route = "feed")
                            },
                            onClickForgotPassword = {
                                myNavController.navigate(route = "paswd")
                            }
                        )
                    }
                    composable(route = "register") {
                        FacebookRegisterScreen(
                            onClickBack = {
                                myNavController.popBackStack()
                            }
                        )
                    }
                    composable(route = "paswd") {
                        PaswdScreen(
                            onClickBack = {
                                myNavController.popBackStack()
                            }
                        )
                    }
                    composable(route = "feed") {
                        FeedScreen(navController = myNavController)
                    }
                }
            }
        }
    }
}
