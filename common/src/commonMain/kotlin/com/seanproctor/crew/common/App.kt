package com.seanproctor.crew.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.seanproctor.crew.common.data.CardRepository
import com.seanproctor.crew.common.data.getPoints
import com.seanproctor.crew.common.models.Card
import kotlinx.coroutines.launch

@Composable
fun App(cardRepository: CardRepository) {
    val scope = rememberCoroutineScope()

    Column(Modifier.padding(16.dp)) {
        var players by remember { mutableStateOf(3) }
        var playersForDraw by remember { mutableStateOf(3) }
        val cardsState = remember { mutableStateOf<List<Card>?>(null) }
        var pointsText by remember { mutableStateOf("1") }

        Row {
            TextField(
                value = players.toString(),
                readOnly = true,
                onValueChange = {}
            )
            Spacer(Modifier.width(8.dp))
            IconButton(
                onClick = { if (players > 3) players -= 1 },
                enabled = players > 3
            ) {
                Text("-")
            }
            Spacer(Modifier.width(8.dp))
            IconButton(
                onClick = { if (players < 5) players += 1 },
                enabled = players < 5
            ) {
                Text("+")
            }
        }
        Spacer(Modifier.height(8.dp))
        TextField(
            value = pointsText,
            onValueChange = {
                pointsText = it
            }
        )
        Spacer(Modifier.height(8.dp))
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
                    Card {
                        Column {
                            Text("Points: ${card.getPoints(playersForDraw)}")
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
