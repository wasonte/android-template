package io.bloco.core.ui.features.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.bloco.core.commons.PublishFlow
import io.bloco.core.commons.logd
import io.bloco.core.domain.models.Book
import io.bloco.core.domain.usecases.GetBooksUseCase
import io.bloco.core.ui.features.list.BookListViewModel.ListScreenUiState.ErrorFromAPI
import io.bloco.core.ui.features.list.BookListViewModel.ListScreenUiState.LoadingFromAPI
import io.bloco.core.ui.features.list.BookListViewModel.ListScreenUiState.UpdateSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase
) : ViewModel() {

    private val events = PublishFlow<Event>()

    private val _state = MutableStateFlow<ListScreenUiState>(LoadingFromAPI)
    val state = _state.asStateFlow()

    private val _inputText: MutableStateFlow<String> = MutableStateFlow("Android")

    init {
        observeRefreshEvent()
        debounceSearchBooks()
    }

    private fun observeRefreshEvent() {
        events
            .filterIsInstance<Event.Refresh>()
            .onEach {
                searchBooks(_inputText.value)
            }
            .launchIn(viewModelScope)
    }

    fun refresh() {
        viewModelScope.launch { events.emit(Event.Refresh) }
    }

    fun updateSearch(keyword: String){
        _inputText.value = keyword
    }

    private suspend fun searchBooks(keyword: String) {
        logd("searchBooks: $keyword ")
        _state.value = LoadingFromAPI
        getBooksUseCase(keyword)
            .onSuccess { _state.value = UpdateSuccess(it) }
            .onFailure { _state.value = ErrorFromAPI }
    }

    private fun debounceSearchBooks() {
        viewModelScope.launch {
            _inputText.debounce(timeoutMillis = 200).collectLatest {
                searchBooks(it)
            }
        }
    }

    private sealed class Event {
        object Refresh : Event()
    }

    sealed interface ListScreenUiState {
        object LoadingFromAPI : ListScreenUiState
        data class UpdateSuccess(val books: List<Book>) : ListScreenUiState
        object ErrorFromAPI : ListScreenUiState
    }
}
