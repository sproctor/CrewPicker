package com.seanproctor.crew.common.data

import com.seanproctor.crew.common.generated.resources.Res
import com.seanproctor.crew.common.models.Card
import kotlinx.serialization.json.Json

class CardDataSource {
    suspend fun getAllCards(): List<Card> {
        val text = Res.readBytes("files/cards.json").decodeToString()
        val jsonCards = Json.decodeFromString<JsonCardList>(text)
        return jsonCards.cards.map { jsonCard ->
            Card(jsonCard.points3, jsonCard.points4, jsonCard.points5, jsonCard.rule)
        }
    }
}
