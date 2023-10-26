package com.kit.remotestoragebackup.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kit.remotestoragebackup.viewmodels.BrowseFoldersViewModel

@Composable
fun BrowseFolderScreen(vm : BrowseFoldersViewModel = viewModel()) {
    LazyColumn{
        items(items = vm.folderList.value.folderList) { f ->
            Text(f.path,
                modifier = Modifier
                    .clickable  {
                            vm.onFolderClick(f.path)
                        }
                )
        }
    }
    /*
    Column {
        vm.folderList.value.folderList.forEach { f ->
            Text(f.path)
        }
    }
     */
}

@Preview
@Composable
fun PreviewBrowse()
{
    BrowseFolderScreen()
}