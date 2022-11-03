package com.seanproctor.crew.common.data

import java.io.File

actual fun readResource(name: String): String {
    val file = File("$RESOURCE_PATH/$name")
    return file.readText()
}