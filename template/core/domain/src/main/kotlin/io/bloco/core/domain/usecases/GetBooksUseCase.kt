package io.bloco.core.domain.usecases

import io.bloco.core.domain.models.Book
import io.bloco.core.domain.repositories.BookRepository
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(): Result<List<Book>> = bookRepository.getBooks()
}
