package com.kit.remotestoragebackup.models

import androidx.core.content.ContextCompat
import com.kit.remotestoragebackup.MyApplication.Companion.appContext
import java.io.File

data class BrowseFolderState(
  val folderList : List<File> = ContextCompat.getExternalFilesDirs(appContext, null).mapNotNull {
    it?.parentFile?.parentFile?.parentFile?.parentFile}

)
