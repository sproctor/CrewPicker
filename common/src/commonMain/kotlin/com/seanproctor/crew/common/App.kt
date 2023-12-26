package com.seanproctor.crew.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.seanproctor.crew.common.components.SegmentedButton
import com.seanproctor.crew.common.data.CardRepository
import com.seanproctor.crew.common.data.getPoints
import com.seanproctor.crew.common.models.Card
import kotlinx.coroutines.launch

@Composable
fun App(cardRepository: CardRepository) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        var players by remember { mutableStateOf(3) }
        var playersForDraw by remember { mutableStateOf(3) }
        val cardsState = remember { mutableStateOf<List<Card>?>(null) }
        var pointsText by remember { mutableStateOf("1") }

        SegmentedButton(
            items = (3..5).map { "$it players" }
        ) {
            players = 3 + it
        }

        TextField(
            value = pointsText,
            onValueChange = {
                pointsText = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        val points = pointsText.toIntOrNull()
        Button(
            onClick = {
                scope.launch {
                    playersForDraw = players
                    cardsState.value = cardRepository.drawCards(players, points ?: 0)
                }
            },
            enabled = points != null,
        ) {
            Text("Draw cards")
        }

        val cards = cardsState.value
        if (cards != null) {
            LazyColumn {
                items(cards) { card ->
                    Card(Modifier.padding(8.dp)) {
                        Column(Modifier.padding(16.dp)) {
                            Text("Points: ${card.getPoints(playersForDraw)}")
                            Spacer(Modifier.height(8.dp))
                            Text("Rule: ${card.rule}")
                        }
                    }
                }
            }
        } else {
            Text("Press button to draw cards")
        }
    }
}
