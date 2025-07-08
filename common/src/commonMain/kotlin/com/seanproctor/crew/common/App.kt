package com.seanproctor.crew.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.seanproctor.crew.common.data.CardRepository
import com.seanproctor.crew.common.data.getPoints
import com.seanproctor.crew.common.generated.resources.Res
import com.seanproctor.crew.common.generated.resources.draw_cards
import com.seanproctor.crew.common.models.Card
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(cardRepository: CardRepository) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        var playersForDraw by rememberSaveable { mutableStateOf(3) }
        val cardsState = rememberSaveable { mutableStateOf<List<Card>?>(null) }
        var pointsText by rememberSaveable { mutableStateOf("") }

        val options = listOf(3, 4, 5)
        var selectedIndex by remember { mutableStateOf(0) }
        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, count ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    onClick = { selectedIndex = index },
                    selected = index == selectedIndex,
                ) {
                    Text("$count players")
                }
            }
        }

        TextField(
            value = pointsText,
            onValueChange = {
                pointsText = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        val points = pointsText.toIntOrNull()
        val players = options[selectedIndex]
        Button(
            onClick = {
                scope.launch {
                    playersForDraw = players
                    cardsState.value = cardRepository.drawCards(players, points ?: 0)
                }
            },
            enabled = points != null,
        ) {
            Text(stringResource(Res.string.draw_cards))
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
