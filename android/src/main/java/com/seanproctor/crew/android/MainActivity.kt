package com.seanproctor.crew.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import com.seanproctor.crew.common.App
import com.seanproctor.crew.common.data.AndroidResourceReader
import com.seanproctor.crew.common.data.CardDataSource
import com.seanproctor.crew.common.data.CardRepository
import kotlinx.coroutines.Dispatchers

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val resourceReader = AndroidResourceReader(this, Dispatchers.IO)
        val cardDataSource = CardDataSource(resourceReader)
        val cardRepository = CardRepository(cardDataSource)
        setContent {
            MaterialTheme {
                App(cardRepository)
            }
        }
    }
}