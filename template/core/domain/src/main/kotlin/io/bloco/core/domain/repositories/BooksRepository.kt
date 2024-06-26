package io.bloco.core.domain.repositories

import io.bloco.core.domain.models.Book
import io.bloco.core.domain.models.BookDetail

interface BooksRepository {

    suspend fun getBooks(keyword: String = "Android"): Result<List<Book>>

    suspend fun getBookDetail(id: String): Result<BookDetail>

}