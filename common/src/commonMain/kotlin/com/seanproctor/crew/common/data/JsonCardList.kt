package com.seanproctor.crew.common.data

import kotlinx.serialization.Serializable

@Serializable
internal data class JsonCardList(
    val cards: List<JsonCard>
)
