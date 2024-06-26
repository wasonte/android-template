package io.bloco.core.ui.features.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.bloco.core.domain.models.BookDetail
import io.bloco.core.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookDetailViewModel @AssistedInject constructor(
    @Assisted bookId: String,
    booksRepository: BooksRepository,
) : ViewModel() {

    private val _updateState =
        MutableStateFlow<UiState>(UiState.LoadingFromAPI)
    val updateState = _updateState.asStateFlow()

    init {
        viewModelScope.launch {
            booksRepository.getBookDetail(bookId)
                .onSuccess { _updateState.value = UiState.Success(it) }
                .onFailure { _updateState.value = UiState.ErrorFromAPI }
        }
    }

    sealed interface UiState {
        object LoadingFromAPI : UiState
        data class Success(val book: BookDetail) : UiState
        object ErrorFromAPI : UiState
    }

    @AssistedFactory
    interface Factory {
        fun create(bookId: String): BookDetailViewModel
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun provideFactory(
            factory: Factory,
            bookId: String,
        ) = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return factory.create(bookId) as T
            }
        }
    }
}
