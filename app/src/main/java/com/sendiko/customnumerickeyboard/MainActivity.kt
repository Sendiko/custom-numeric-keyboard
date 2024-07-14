package com.sendiko.customnumerickeyboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sendiko.customnumerickeyboard.about.AboutScreen
import com.sendiko.customnumerickeyboard.home.HomeScreen
import com.sendiko.customnumerickeyboard.home.HomeScreenViewModel
import com.sendiko.customnumerickeyboard.navigation.AboutScreen
import com.sendiko.customnumerickeyboard.navigation.HomeScreen
import com.sendiko.customnumerickeyboard.ui.theme.CustomNumericKeyboardTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomNumericKeyboardTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = HomeScreen) {
                    composable<HomeScreen> {
                        val viewModel = viewModel<HomeScreenViewModel>()
                        val state by viewModel.state.collectAsState()
                        HomeScreen(
                            state = state,
                            onEvent = viewModel::onEvent,
                            onNavigate = { navController.navigate(AboutScreen) }
                        )
                    }
                    composable<AboutScreen> {
                        AboutScreen(
                            onNavigate = {
                                navController.navigateUp()
                            }
                        )
                    }
                }
            }
        }
    }
}