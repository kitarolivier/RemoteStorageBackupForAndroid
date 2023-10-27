package com.kit.remotestoragebackup.models

data class UsbDevice(
    val id : String,
    val model : String,
    val manufacturer : String,
    val type : String
) {

    override
    fun toString() :String {
        return "${id},${model},${manufacturer},${type}"
    }
}