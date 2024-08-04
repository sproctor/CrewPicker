package com.seanproctor.crew.common.data

import android.content.Context
import com.seanproctor.crew.common.MR
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AndroidResourceReader(
    private val context: Context,
    private val dispatcher: CoroutineDispatcher,
) : ResourceReader {
    override suspend fun readText(): String {
        return withContext(dispatcher) {
            MR.files.cards_json.readText(context)
        }
    }
}