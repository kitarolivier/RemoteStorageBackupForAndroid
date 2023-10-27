package com.kit.remotestoragebackup.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.kit.remotestoragebackup.BuildConfig
import com.kit.remotestoragebackup.ui.screens.MainScreen
import com.kit.remotestoragebackup.ui.theme.RemoteStorageBackupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val uri = Uri.parse("package:${BuildConfig.APPLICATION_ID}")

        /* TODO Check permissions
        startActivity(
            Intent(
                Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION,
                uri
            )
        )
        */

        //val volumeNames = MediaStore.getExternalVolumeNames(this).toTypedArray()

            //    it?.parentFile?.parentFile?.parentFile?.parentFile})

        //val publicStorages = ContextCompat.getExternalFilesDirs(this, null).mapNotNull {
        //    it?.parentFile?.parentFile?.parentFile?.parentFile}

        setContent {
            RemoteStorageBackupTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                      MainScreen()
                }
            }
        }
    }
}
