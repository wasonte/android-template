package io.bloco.core.domain.repositories

import kotlinx.coroutines.flow.Flow

interface AppRepository {

    suspend fun saveHasBeenOpenedPreference()

    fun hasBeenOpened(): Flow<Boolean>
}