package com.kit.remotestoragebackup.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.kit.remotestoragebackup.ui.theme.RemoteStorageBackupTheme

class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //val volumeNames = MediaStore.getExternalVolumeNames(this).toTypedArray()

            //    it?.parentFile?.parentFile?.parentFile?.parentFile})

        val publicStorages = ContextCompat.getExternalFilesDirs(this, null).mapNotNull {
            it?.parentFile?.parentFile?.parentFile?.parentFile}

        setContent {
            RemoteStorageBackupTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                      NavigationScreen()
                }
            }
        }
    }
}
