package com.fitless.common

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream


/**
 * Serializer implementation for serializing and deserializing UserData objects.
 * This class is responsible for converting UserData objects to and from JSON format.
 */
class UserDataSerializer: Serializer<UserData> {

    /**
     * Default value for UserData objects.
     * This value is used if deserialization fails or if the input stream is empty.
     */
    override val defaultValue: UserData
        get() = UserData()

    /**
     * Deserialize a UserData object from the given input stream.
     *
     * @param input The input stream from which to read UserData data.
     * @return The deserialized UserData object.
     */
    override suspend fun readFrom(input: InputStream): UserData {
        return try {
            Json.decodeFromString(
                deserializer = UserData.serializer(),
                string = input.readBytes().decodeToString()
            )
        }catch (e: SerializationException){
            e.printStackTrace()
            defaultValue
        }
    }

    /**
     * Serialize the given UserData object and write it to the output stream.
     *
     * @param t The UserData object to be serialized.
     * @param output The output stream to which the serialized data will be written.
     */
    override suspend fun writeTo(t: UserData, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = UserData.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }
}