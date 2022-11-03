package com.seanproctor.crew.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.runtime.*
import com.seanproctor.crew.common.data.CardRepository
import com.seanproctor.crew.common.models.Card
import kotlinx.coroutines.launch

@Composable
fun App(cardRepository: CardRepository) {
    val cardsState = remember { mutableStateOf<List<Card>?>(null) }
    val scope = rememberCoroutineScope()

    Column {
        Button(onClick = {
            scope.launch {
                cardsState.value = cardRepository.drawCards(3, 5)
            }
        }) {
            Text("Draw cards")
        }

        val cards = cardsState.value
        if (cards != null) {
            LazyColumn {
                items(cards) { card ->
                    Card {
                        Text("Rule: ${card.rule}")
                    }
                }
            }
        } else {
            Text("Press button to draw cards")
        }
    }
}
