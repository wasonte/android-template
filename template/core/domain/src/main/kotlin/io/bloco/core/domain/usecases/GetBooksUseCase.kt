package io.bloco.core.domain.usecases

import io.bloco.core.domain.models.Book
import io.bloco.core.domain.repositories.BooksRepository
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val booksRepository: BooksRepository
) {
    suspend operator fun invoke(): Result<List<Book>> = booksRepository.getBooks()
}
