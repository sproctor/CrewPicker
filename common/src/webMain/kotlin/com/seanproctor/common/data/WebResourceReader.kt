package com.seanproctor.common.data

import com.seanproctor.crew.common.MR
import com.seanproctor.crew.common.data.ResourceReader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class WebResourceReader(
    private val dispatcher: CoroutineDispatcher,
) : ResourceReader {
    override suspend fun readText(): String {
        return withContext(dispatcher) {
            MR.files.cards_json.getText()
        }
    }
}