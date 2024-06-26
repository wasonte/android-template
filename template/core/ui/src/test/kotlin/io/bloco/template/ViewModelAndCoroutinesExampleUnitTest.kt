package io.bloco.template

import app.cash.turbine.test
import io.bloco.core.domain.usecases.GetBooksUseCase
import io.bloco.core.domain.models.Book
import io.bloco.core.ui.features.list.BookListViewModel
import io.bloco.core.ui.features.list.BookListViewModel.ListScreenUiState.ErrorFromAPI
import io.bloco.core.ui.features.list.BookListViewModel.ListScreenUiState.LoadingFromAPI
import io.bloco.core.ui.features.list.BookListViewModel.ListScreenUiState.UpdateSuccess
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ViewModelAndCoroutinesExampleUnitTest {

    @get:Rule
    val coroutinesTestRule = MockMainDispatcherTestRule()

    private val getBooksMock = mockk<GetBooksUseCase>()

    private fun buildVM(): BookListViewModel = BookListViewModel(
        getBooksMock
    )

    @Test
    fun `Test Initial State`() = runTest(coroutinesTestRule.testDispatcher) {
        // Arrange
        val vm = buildVM()

        // Assert
        vm.state.test {
            assertThat(
                awaitItem(),
                instanceOf(LoadingFromAPI::class.java)
            )
        }
    }

    @Test
    fun `Test Refresh`() = runTest(coroutinesTestRule.testDispatcher) {
        // Arrange
        val result = Result.success(listOf(Book("1", "bloco.io")))
        coEvery { getBooksMock.invoke() } returns result

        val vm = buildVM()

        // Act
        vm.refresh()

        // Assert
        vm.state.test {
            assertEquals(
                awaitItem(),
                UpdateSuccess(result.getOrThrow())
            )
        }
    }

    @Test
    fun `Test Error State`() = runTest(coroutinesTestRule.testDispatcher) {
        // Arrange
        val result: Result<List<Book>> = Result.failure(Exception(""))
        coEvery { getBooksMock.invoke() } returns result

        val vm = buildVM()

        // Act
        vm.refresh()

        // Assert
        vm.state.test {
            assertThat(
                awaitItem(),
                instanceOf(ErrorFromAPI::class.java)
            )
        }
    }
}
