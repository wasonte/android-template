@file:Suppress("MatchingDeclarationName")
package io.bloco.template.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.EntryPointAccessors
import io.bloco.template.MainActivity.ViewModelFactoryProvider
import io.bloco.core.ui.features.detail.BookDetailViewModel

interface BaseViewModelFactoryProvider {
    fun getDetailsViewModelFactory(): BookDetailViewModel.Factory
}

@Composable
fun detailViewModel(bookId: String): BookDetailViewModel = viewModel(
    factory = BookDetailViewModel.provideFactory(
        getViewModelFactoryProvider().getDetailsViewModelFactory(),
        bookId
    )
)

@Composable
private fun getViewModelFactoryProvider() = EntryPointAccessors.fromActivity(
    LocalContext.current as Activity,
    ViewModelFactoryProvider::class.java
)
