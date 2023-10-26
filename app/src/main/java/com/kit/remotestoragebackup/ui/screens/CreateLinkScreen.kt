package com.kit.remotestoragebackup.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.kit.remotestoragebackup.viewmodels.CreateLinkViewModel

@Composable
fun CreateLinkScreen(navHostController: NavHostController, mainActivityViewModel: CreateLinkViewModel = viewModel()) {
//fun MainActivityScreen(gameViewModel: MainActivityViewModel = viewModel()) {
    // UI that reacts to state changes

    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        OutlinedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Text(
                text = "Source",
                color = MaterialTheme.colorScheme.onSecondary,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary),
                textAlign = TextAlign.Center,
            )
            Row {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    shape = RoundedCornerShape(0.dp),
                ) {
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
                            Text(
                                "Select ...",
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
        }
    }
}