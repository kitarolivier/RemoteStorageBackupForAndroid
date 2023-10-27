package com.kit.remotestoragebackup.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kit.remotestoragebackup.models.DisplayFolderList
import com.kit.remotestoragebackup.viewmodels.BrowseFoldersViewModel

@Composable
fun BrowseFolderScreen(vm : BrowseFoldersViewModel = viewModel()) {

    DisplayFolderList(state = vm.folderList.value)
}

@Preview
@Composable
fun PreviewBrowse()
{
    BrowseFolderScreen()
}