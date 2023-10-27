package com.kit.remotestoragebackup.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kit.remotestoragebackup.models.BrowseFolderState
import com.kit.remotestoragebackup.models.FolderObject


class BrowseFoldersViewModel : ViewModel() {
    // MutableState to handle our UI state
    var folderList = mutableStateOf(BrowseFolderState())
}