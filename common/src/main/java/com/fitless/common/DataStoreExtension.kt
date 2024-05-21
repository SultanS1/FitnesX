package com.fitless.common

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore

val Context.userDataStore: DataStore<UserData> by dataStore(
    fileName = "user_data.json",
    serializer = UserDataSerializer()
)