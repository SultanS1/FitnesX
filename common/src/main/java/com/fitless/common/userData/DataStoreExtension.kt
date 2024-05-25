package com.fitless.common.userData

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore

val Context.userDataStore: DataStore<UserData> by dataStore(
    fileName = "user_data.json",
    serializer = UserDataSerializer
)

val Context.userBioDataStore: DataStore<UserBio> by dataStore(
    fileName = "user_bio.json",
    serializer = UserBioSerializer
)