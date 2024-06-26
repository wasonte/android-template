package io.bloco.core.data.features.books.dto

import io.bloco.core.domain.models.Book
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

private const val KEY_PREFIX = "/works/"

@Serializable
data class BookDto(
    @SerialName("key")
    val key: String,
    @SerialName("title")
    val title: String
)

fun BookDto.toModel(): Book = Book(
    key = key.removePrefix(KEY_PREFIX),
    title = title
)
