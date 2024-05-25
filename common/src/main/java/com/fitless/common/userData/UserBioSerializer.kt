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
object UserBioSerializer : Serializer<UserBio> {
    override val defaultValue: UserBio = UserBio()

    override suspend fun readFrom(input: InputStream): UserBio {
        return try {
             Json.decodeFromString(
                deserializer = UserBio.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException){
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(
        t: UserBio,
        output: OutputStream){
        output.write(
            Json.encodeToString(
                serializer = UserBio.serializer(),
                value = t
            ).encodeToByteArray()
        )

    }

}