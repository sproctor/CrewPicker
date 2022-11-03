package com.seanproctor.crew.common.data

import com.seanproctor.crew.common.models.Card

class CardRepository(
    private val cardDataSource: CardDataSource
) {
    suspend fun drawCards(players: Int, points: Int): List<Card> {
        check(players in 3..5)
        val cards = cardDataSource.getAllCards()
        val remainingCards = cards.shuffled().toMutableList()
        var remainingPoints = points
        val chosenCards = mutableListOf<Card>()
        while (remainingPoints > 0) {
            if (remainingCards.isEmpty())
                throw Exception("Not enough cards to satisfy condition")
            val card = remainingCards.first()
            remainingCards.removeFirst()
            val cardValue = card.getPoints(players)
            if (cardValue > remainingPoints)
                continue
            chosenCards += card
            remainingPoints -= cardValue
        }
        return chosenCards
    }
}

fun Card.getPoints(players: Int): Int {
    return when (players) {
        3 -> points3
        4 -> points4
        5 -> points5
        else -> throw Exception("Invalid player count")
    }
}