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
import me.juanmora.facebook.ui.theme.FacebookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FacebookTheme {
                val miNavController = rememberNavController()

                NavHost(
                    navController = miNavController,
                    startDestination = "login",
                    modifier = Modifier.fillMaxSize()
                ) {
                    composable(route = "login") {
                        FacebookLoginScreen(myNavController = miNavController)
                    }
                    composable(route = "register") {
                        FacebookRegisterScreen(myNavController = miNavController)
                    }
                }
            }
        }
    }
}


