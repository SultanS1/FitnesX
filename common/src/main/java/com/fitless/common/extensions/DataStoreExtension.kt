package com.fitless.common.extensions

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.fitless.common.userData.UserBio
import com.fitless.common.userData.UserBioSerializer
import com.fitless.common.userData.UserData
import com.fitless.common.userData.UserDataSerializer

val Context.userDataStore: DataStore<UserData> by dataStore(
    fileName = "user_data.json",
    serializer = UserDataSerializer
)

val Context.userBioDataStore: DataStore<UserBio> by dataStore(
    fileName = "user_bio.json",
    serializer = UserBioSerializer
)