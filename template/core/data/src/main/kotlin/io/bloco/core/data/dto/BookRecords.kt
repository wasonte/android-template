package io.bloco.core.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookRecords(
    @SerialName("numFound")
    val numFound: Int,
    @SerialName("docs")
    val docs: List<BookDto>,
)
