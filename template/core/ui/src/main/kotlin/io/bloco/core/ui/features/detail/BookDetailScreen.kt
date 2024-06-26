package io.bloco.core.ui.features.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.bloco.core.ui.R
import io.bloco.core.ui.component.Toast

@Composable
fun DetailsScreen(bookDetailViewModel: BookDetailViewModel) {
    val bookListUpdateState by bookDetailViewModel.updateState.collectAsState()

    when (val state = bookListUpdateState) {
        BookDetailViewModel.UiState.ErrorFromAPI -> Toast(R.string.api_error)
        BookDetailViewModel.UiState.LoadingFromAPI -> Unit
        is BookDetailViewModel.UiState.Success -> {
            Column(
                modifier = Modifier
                    .systemBarsPadding()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = stringResource(id = R.string.book_title, state.book.title),
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = state.book.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
            }
        }
    }
}
