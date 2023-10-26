package com.kit.remotestoragebackup.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kit.remotestoragebackup.viewmodels.MainActivityViewModel

@Composable
fun NavigationScreen() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "First"){
        composable("First"){
            MainActivityScreen( navController)
        }
        composable("Second"){
            BrowseFolderActivityScreen()
        }
    }

}

@Composable
fun MainActivityScreen( navHostController: NavHostController,mainActivityViewModel: MainActivityViewModel = viewModel()) {
//fun MainActivityScreen(gameViewModel: MainActivityViewModel = viewModel()) {
    // UI that reacts to state changes

    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        OutlinedCard (
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary)
        ){
            Text(text = "Source",
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary),
                textAlign =  TextAlign.Center,
            )
            Row {
                Card (modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                shape = RoundedCornerShape(0.dp),
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "emulated / Storage/ Dscim/panoaram/test23/bruxeeles/img/wre are the world/this is too long",
                            modifier = Modifier.padding(5.dp)
                            )
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(
                            onClick = { navHostController.navigate("second") },
                        ) {
                            Text("Select ...",
                                fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}



@Composable
@Preview
fun Preview()
{
    //val vm : MainActivityViewModel = MainActivityViewModel()
    NavigationScreen()
}
