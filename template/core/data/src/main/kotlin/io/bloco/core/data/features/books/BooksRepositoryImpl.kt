package io.bloco.core.data.features.books

import io.bloco.core.data.features.books.dto.toModel
import io.bloco.core.domain.models.Book
import io.bloco.core.domain.models.BookDetail
import io.bloco.core.domain.repositories.BooksRepository
import javax.inject.Inject

class BooksRepositoryImpl
@Inject constructor(
    private val booksDataSource: BooksDataSource
): BooksRepository {
    override suspend fun getBooks(keyword: String): Result<List<Book>> =
        booksDataSource.getBooks(keyword).map {
            it.docs
        }.map {
            books -> books.map { it.toModel() }
        }

    override suspend fun getBookDetail(id: String): Result<BookDetail> =
        booksDataSource.getBookDetail(id).map { it.toModel() }
}
