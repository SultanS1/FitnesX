package com.fitless.authorization.registration.registration.domain.usecase

import com.fitless.authorization.registration.registration.domain.model.PasswordStatus
import com.fitless.common.validation.EmailStatus
import com.fitless.common.validation.TextStatus

class ConfirmValidationsUseCase {

    operator fun invoke(
        name: TextStatus,
        surname: TextStatus,
        email: EmailStatus,
        password: PasswordStatus): Boolean{
        return name == TextStatus.OK
                && surname == TextStatus.OK
                && email == EmailStatus.OK
                && password == PasswordStatus.OK
    }

}