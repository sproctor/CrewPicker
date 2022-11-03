package com.seanproctor.crew.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.seanproctor.crew.common.App
import com.seanproctor.crew.common.data.CardDataSource
import com.seanproctor.crew.common.data.CardRepository
import kotlinx.coroutines.Dispatchers

fun main() {
    val cardDataSource = CardDataSource(Dispatchers.IO)
    val cardRepository = CardRepository(cardDataSource)
    application {
        Window(onCloseRequest = ::exitApplication) {
            App(cardRepository)
        }
    }
}
