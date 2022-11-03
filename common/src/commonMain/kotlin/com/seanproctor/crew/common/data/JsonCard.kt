package com.seanproctor.crew.common.data

import kotlinx.serialization.Serializable

@Serializable
internal data class JsonCard(
    val points3: Int,
    val points4: Int,
    val points5: Int,
    val rule: String,
)