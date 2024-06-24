package io.bloco.core.data.repositories

import io.bloco.core.data.dto.toModel
import io.bloco.core.data.network.OpenLibraryService
import io.bloco.core.domain.models.Book
import io.bloco.core.domain.models.BookDetails
import io.bloco.core.domain.repositories.BookRepository
import javax.inject.Inject

class BookRepositoryImpl
@Inject constructor(
    private val openLibraryService: OpenLibraryService
): BookRepository {
    override suspend fun getBooks(keyword: String): Result<List<Book>> =
        openLibraryService.getBooks(keyword).map {
            it.docs
        }.map {
            books -> books.map { it.toModel() }
        }

    override suspend fun getBookDetails(id: String): Result<BookDetails> =
        openLibraryService.getBook(id).map { it.toModel() }
}
