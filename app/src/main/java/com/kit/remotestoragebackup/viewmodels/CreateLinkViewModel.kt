package com.kit.remotestoragebackup.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class CreateLinkViewModel : ViewModel() {
    // MutableState to handle our UI state
    var sourcePath = mutableStateOf("")

    init {
        loadDefaults()
    }

    fun loadDefaults() {

    }

}