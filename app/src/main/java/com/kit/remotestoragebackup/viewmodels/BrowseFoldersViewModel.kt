package com.kit.remotestoragebackup.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kit.remotestoragebackup.models.BrowseFolderState


class BrowseFoldersViewModel : ViewModel() {
    // MutableState to handle our UI state
    var folderList = mutableStateOf(BrowseFolderState())

    fun onFolderClick(path:String) {

    }
}