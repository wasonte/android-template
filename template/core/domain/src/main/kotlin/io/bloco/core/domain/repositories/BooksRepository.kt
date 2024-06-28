package io.bloco.core.domain.repositories

import io.bloco.core.domain.models.Book
import io.bloco.core.domain.models.BookDetail

interface BooksRepository {

    suspend fun getBooks(keyword: String): Result<List<Book>>

    suspend fun getBookDetail(id: String): Result<BookDetail>

}