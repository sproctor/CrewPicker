package com.seanproctor.crew.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.seanproctor.crew.common.data.CardRepository
import com.seanproctor.crew.common.data.getPoints
import com.seanproctor.crew.common.models.Card
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.coroutines.launch

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
            Text(stringResource(MR.strings.draw_cards))
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
