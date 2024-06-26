package io.bloco.core.domain.usecases

import io.bloco.core.domain.models.BookDetail
import io.bloco.core.domain.repositories.BookRepository
import javax.inject.Inject

class GetBookUseCase @Inject constructor(
    private val bookRepository: BookRepository,
) {
    suspend operator fun invoke(id: String): Result<BookDetail> = bookRepository.getBookDetails(id)
}
