package com.kit.remotestoragebackup.models

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import java.io.File

enum class FolderType {
    STORAGE,
    USB,
    MOUNTED_VOLUME
}
class FolderObject(
    var folderType : FolderType,
    var folder : Any
) {
}
