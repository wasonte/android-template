package io.bloco.core.data.repositories

import io.bloco.core.data.dto.BookDetailsDto
import io.bloco.core.data.dto.BookRecords
import io.bloco.core.data.network.OpenLibraryService
import javax.inject.Inject

class BookRepository
@Inject constructor(
    private val openLibraryService: OpenLibraryService
) {
    suspend fun getBooks(keyword: String = "Android"): Result<BookRecords> =
        openLibraryService.getBooks(keyword)

    suspend fun getBookDetails(id: String): Result<BookDetailsDto> =
        openLibraryService.getBook(id)
}
