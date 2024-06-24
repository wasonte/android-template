package io.bloco.core.data.dto

import io.bloco.core.domain.models.BookDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookDetailsDto(
    @SerialName("title")
    val title: String
)

fun BookDetailsDto.toModel(): BookDetails = BookDetails(
    title = title
)
