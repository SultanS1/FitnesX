package com.fitless.common.userData

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

class FileStorage<T>(
    private val dataStore: DataStore<T>,
    private val defaultInstance: T
) {

    val data: Flow<T> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(defaultInstance)
            } else {
                throw exception
            }
        }

    suspend fun saveData(transform: (T) -> T) {
        dataStore.updateData { currentData ->
            transform(currentData)
        }
    }

}