package io.bloco.core.data.features.books

import io.bloco.core.data.features.books.dto.toModel
import io.bloco.core.domain.models.Book
import io.bloco.core.domain.models.BookDetail
import io.bloco.core.domain.repositories.BookRepository
import javax.inject.Inject

class BookRepositoryImpl
@Inject constructor(
    private val booksDataSource: BooksDataSource
): BookRepository {
    override suspend fun getBooks(keyword: String): Result<List<Book>> =
        booksDataSource.getBooks(keyword).map {
            it.docs
        }.map {
            books -> books.map { it.toModel() }
        }

    override suspend fun getBookDetails(id: String): Result<BookDetail> =
        booksDataSource.getBookDetail(id).map { it.toModel() }
}
