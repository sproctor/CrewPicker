package com.seanproctor.crew.common.data

interface ResourceReader {
    suspend fun readText(): String
}