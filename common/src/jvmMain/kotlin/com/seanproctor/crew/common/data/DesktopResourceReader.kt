package com.seanproctor.crew.common.data

import com.seanproctor.crew.common.MR
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DesktopResourceReader(
    private val dispatcher: CoroutineDispatcher,
) : ResourceReader {
    override suspend fun readText(): String {
        return withContext(dispatcher) {
            MR.files.cards.readText()
        }
    }
}