package com.seanproctor.crew.desktop

import androidx.compose.ui.window.singleWindowApplication
import com.seanproctor.crew.common.App
import com.seanproctor.crew.common.data.CardDataSource
import com.seanproctor.crew.common.data.CardRepository
import com.seanproctor.crew.common.data.DesktopResourceReader
import kotlinx.coroutines.Dispatchers

fun main() {
    val cardDataSource = CardDataSource(DesktopResourceReader(Dispatchers.IO))
    val cardRepository = CardRepository(cardDataSource)
    singleWindowApplication(
        title = "Card picker"
    ) {
        App(cardRepository)
    }
}
