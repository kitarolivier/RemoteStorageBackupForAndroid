package com.kit.remotestoragebackup.utils

sealed class MyEvents {
    object ToBrowseFolderActivity: MyEvents()
    object ToAnotherActivity: MyEvents()
    data class ToastMessage(val message: String):MyEvents()
}
