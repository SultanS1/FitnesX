package com.fitless.common.userData

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream


/**
 * Serializer implementation for serializing and deserializing UserData objects.
 * This class is responsible for converting UserData objects to and from JSON format.
 */
object UserDataSerializer : Serializer<UserData> {

    override val defaultValue: UserData = UserData()

    override suspend fun readFrom(input: InputStream): UserData {
        return try {
            Json.decodeFromString(
                deserializer = UserData.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException){
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(
        t: UserData,
        output: OutputStream){
        output.write(
            Json.encodeToString(
                serializer = UserData.serializer(),
                value = t
            ).encodeToByteArray()
        )

    }

}