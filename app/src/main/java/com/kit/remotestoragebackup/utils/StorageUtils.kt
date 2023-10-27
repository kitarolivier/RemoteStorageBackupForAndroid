package com.kit.remotestoragebackup.utils

import android.os.Environment
import android.util.Log
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.util.Arrays
import java.util.StringTokenizer


class StorageUtils {
    private val TAG = "StorageUtils"
    val storageList: List<StorageInfo>
        get() {
            val list: MutableList<StorageInfo> = ArrayList()
            val def_path = Environment.getExternalStorageDirectory().path
            val def_path_removable = Environment.isExternalStorageRemovable()
            val def_path_state = Environment.getExternalStorageState()
            val def_path_available =
                def_path_state == Environment.MEDIA_MOUNTED || def_path_state == Environment.MEDIA_MOUNTED_READ_ONLY
            val def_path_readonly =
                Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED_READ_ONLY
            val paths = HashSet<String>()
            var cur_removable_number = 1
            if (def_path_available) {
                paths.add(def_path)
                list.add(
                    0,
                    StorageInfo(
                        def_path,
                        def_path_readonly,
                        def_path_removable,
                        if (def_path_removable) cur_removable_number++ else -1
                    )
                )
            }
            var buf_reader: BufferedReader? = null
            try {
                buf_reader = BufferedReader(FileReader("/proc/mounts"))
                var line: String
                Log.d(TAG, "/proc/mounts")
                while (buf_reader.readLine().also { line = it } != null) {
                    Log.d(TAG, line)
                    if (line.contains("vfat") || line.contains("/mnt")) {
                        val tokens = StringTokenizer(line, " ")
                        var unused = tokens.nextToken() //device
                        val mount_point = tokens.nextToken() //mount point
                        if (paths.contains(mount_point)) {
                            continue
                        }
                        unused = tokens.nextToken() //file system
                        val flags = Arrays.asList(
                            *tokens.nextToken().split(",".toRegex()).dropLastWhile { it.isEmpty() }
                                .toTypedArray()) //flags
                        val readonly = flags.contains("ro")
                        if (line.contains("/dev/block/vold")) {
                            if (!line.contains("/mnt/secure")
                                && !line.contains("/mnt/asec")
                                && !line.contains("/mnt/obb")
                                && !line.contains("/dev/mapper")
                                && !line.contains("tmpfs")
                            ) {
                                paths.add(mount_point)
                                list.add(
                                    StorageInfo(
                                        mount_point,
                                        readonly,
                                        true,
                                        cur_removable_number++
                                    )
                                )
                            }
                        }
                    }
                }
            } catch (ex: FileNotFoundException) {
                ex.printStackTrace()
            } catch (ex: IOException) {
                ex.printStackTrace()
            } finally {
                if (buf_reader != null) {
                    try {
                        buf_reader.close()
                    } catch (ex: IOException) {
                    }
                }
            }
            return list
        }

    class StorageInfo internal constructor(
        val path: String,
        val readonly: Boolean,
        val removable: Boolean,
        val number: Int
    ) {

        val displayName: String
            get() {
                val res = StringBuilder()
                if (!removable) {
                    res.append("Internal SD card")
                } else if (number > 1) {
                    res.append("SD card $number")
                } else {
                    res.append("SD card")
                }
                if (readonly) {
                    res.append(" (Read only)")
                }
                return res.toString()
            }
    }
}