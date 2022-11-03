package com.seanproctor.common.data

import com.seanproctor.crew.common.data.RESOURCE_PATH

private external fun require(module: String): dynamic
private val fs = require("fs")

actual fun readResource(name: String): String {
    val path = "$RESOURCE_PATH/$name"
    return fs.readFileSync(path, "utf8") as String
}