package io.bloco.core.data.features.books.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BooksDTO(
    @SerialName("numFound")
    val numFound: Int,
    @SerialName("docs")
    val docs: List<BookDto>,
)
