package com.seanproctor.crew.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.seanproctor.crew.common.App
import com.seanproctor.crew.common.data.CardDataSource
import com.seanproctor.crew.common.data.CardRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cardDataSource = CardDataSource()
        val cardRepository = CardRepository(cardDataSource)
        setContent {
            App(cardRepository)
        }
    }
}
