package com.kit.remotestoragebackup.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.kit.remotestoragebackup.MyApplication.Companion.appContext
import com.kit.remotestoragebackup.models.StorageListState
import com.kit.remotestoragebackup.utils.MyEvents
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow


class MainActivityViewModel : ViewModel() {
    // MutableState to handle our UI state
    var sourcePath = mutableStateOf("")

    private val _events = MutableSharedFlow<MyEvents>()
    val events: SharedFlow<MyEvents> = _events


    init {
        loadDefaults()
    }

    fun loadDefaults() {

    }

}