package io.bloco.template.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.bloco.core.data.features.app.AppRepositoryImpl
import io.bloco.core.data.features.books.BooksRepositoryImpl
import io.bloco.core.domain.repositories.AppRepository
import io.bloco.core.domain.repositories.BooksRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    internal abstract fun bindsAppRepository(
        appRepositoryImpl: AppRepositoryImpl,
    ): AppRepository

    @Binds
    internal abstract fun bindsBookRepository(
        bookRepositoryImpl: BooksRepositoryImpl,
    ): BooksRepository

}
