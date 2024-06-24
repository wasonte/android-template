package io.bloco.core.domain.usecases

import io.bloco.core.commons.logd
import io.bloco.core.data.repositories.BookRepository
import io.bloco.core.domain.models.BookDetails
import io.bloco.core.domain.models.toModel
import javax.inject.Inject

class GetBookUseCase @Inject constructor(
    private val bookRepository: BookRepository,
) {
    suspend operator fun invoke(id: String): Result<BookDetails> {
        return bookRepository.getBookDetails(id).map { bookDetails ->
            logd("Title: " + bookDetails.title)
            bookDetails.toModel()
        }
    }
}
