package com.kit.remotestoragebackup.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "First") {
        composable("First") {
            CreateLinkScreen(navController)
        }
        composable("Second") {
            BrowseFolderScreen()
        }
    }

}