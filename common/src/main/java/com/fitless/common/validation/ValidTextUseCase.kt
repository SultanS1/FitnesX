package com.fitless.common.validation

/**
 * Validates the name field.
 * @param name The name to be validated.
 * @return True if the name is not empty, false otherwise.
 */
class ValidTextUseCase {

    operator fun invoke(text: String): TextStatus{
        if (text.length < 2){
            return TextStatus.TOO_SHORT
        }
        return if(text.isEmpty()) TextStatus.EMPTY else TextStatus.OK

    }

}