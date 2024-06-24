package io.bloco.core.domain.repositories

import io.bloco.core.domain.models.Book
import io.bloco.core.domain.models.BookDetails

interface BookRepository {

    suspend fun getBooks(keyword: String = "Android"): Result<List<Book>>

    suspend fun getBookDetails(id: String): Result<BookDetails>

}