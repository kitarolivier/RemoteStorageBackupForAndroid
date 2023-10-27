package com.kit.remotestoragebackup.models

import android.app.AppOpsManager
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.core.content.PackageManagerCompat.LOG_TAG
import com.kit.remotestoragebackup.MyApplication.Companion.appContext
import com.kit.remotestoragebackup.utils.StorageUtils
import java.io.File
import java.lang.reflect.InvocationTargetException


class BrowseFolderState {
  var folderList : ArrayList<FolderObject>

  var currentFolder : FolderObject? = null

  init {
    folderList = ArrayList<FolderObject>()

    val storage = StorageUtils()
      .storageList

    storage.forEach { s ->
      val mounted = MountedFolder(s.path)
      folderList.add(FolderObject( FolderType.MOUNTED_VOLUME,mounted as Any))
    }


    /*
    val usbManager: UsbManager = appContext.getSystemService(Context.USB_SERVICE) as UsbManager
    for (device in usbManager.deviceList.values) {
      val dev = UsbDevice(id=device.deviceId.toString(), model = device.deviceName, manufacturer = device.manufacturerName.toString(),type="device")
      val folder = FolderObject (folderType = FolderType.USB, folder = dev as Any)
      folderList.add(folder)
    }
    if (usbManager.accessoryList != null) {
      for (accessory in usbManager.accessoryList) {
        val dev = UsbDevice(id= accessory.serial.toString(),model=accessory.model, manufacturer = accessory.manufacturer, type = "accessory")
        val folder = FolderObject (folderType = FolderType.USB, dev as Any)
        folderList.add(folder)
      }
    }
  */
    /*
    //Internal / External / Usb storage
    val publicStorages = ContextCompat.getExternalFilesDirs(appContext, null).mapNotNull {
      it?.parentFile?.parentFile?.parentFile?.parentFile}

    publicStorages.forEach {
      s ->
      val f = FolderObject(FolderType.STORAGE,s)
      folderList.add(f)
    }
     */
  }

  fun onFolderClick(folder:FolderObject) {
    currentFolder = folder
  }


}
@Composable
fun DisplayFolderList(state : BrowseFolderState) {

  Column {


    Box {
      if (state.currentFolder == null) {
        Text("Device Name") //TODO
      } else {
        Text("This Directory")
      }
    }
    LazyColumn {
      items(state.folderList) { f ->
        when (f.folderType) {
          FolderType.STORAGE -> {
            val file: File = f.folder as File
            ClickableText(
              onClick = { state.onFolderClick(folder = f) },
              text = AnnotatedString(file.path),
              style = TextStyle(color = Color.White)
            )
          }
          FolderType.USB-> {
            val d : UsbDevice = f.folder as UsbDevice
            ClickableText(
              onClick = { state.onFolderClick(folder = f) },
              text = AnnotatedString(d.toString()),
              style = TextStyle(color = Color.Red)
            )
          }
          FolderType.MOUNTED_VOLUME -> {
            val m = f.folder as MountedFolder
            ClickableText(
              onClick = { state.onFolderClick(folder = f) },
              text = AnnotatedString(m.volume),
              style = TextStyle(color = Color.Green)
            )
          }
        }
      }
    }
  }
}
