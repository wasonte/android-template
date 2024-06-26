package io.bloco.core.data.features.books.dto

import io.bloco.core.domain.models.BookDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookDetailDTO(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String
)

fun BookDetailDTO.toModel(): BookDetail = BookDetail(
    title = title,
    description = description
)
