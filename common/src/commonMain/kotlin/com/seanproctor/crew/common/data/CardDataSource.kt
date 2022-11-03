package com.seanproctor.crew.common.data

import com.seanproctor.crew.common.models.Card
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class CardDataSource(
    private val resourceReader: ResourceReader
) {
    suspend fun getAllCards(): List<Card> {
        val text = resourceReader.readText()
        val jsonCards = Json.decodeFromString<JsonCardList>(text)
        return jsonCards.cards.map { jsonCard ->
            Card(jsonCard.points3, jsonCard.points4, jsonCard.points5, jsonCard.rule)
        }
    }
}
