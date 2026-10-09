package me.juanmora.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.juanmora.facebook.ui.theme.FacebookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val miNavController = rememberNavController()

            NavHost(
                navController = miNavController,
                startDestination = "Login",
                modifier = Modifier.fillMaxSize()

            ) {

                composable(route = "login"){
                    FacebookLoginScreen()
                }
                composable(route = "register"){
                    FacebookRegisterScreen()
                }

            }



        }
    }
}

