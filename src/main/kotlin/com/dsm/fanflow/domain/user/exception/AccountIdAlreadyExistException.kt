package com.dsm.fanflow.domain.user.exception

import com.dsm.fanflow.global.error.exception.ErrorCode
import com.dsm.fanflow.global.error.exception.FanflowException

object AccountIdAlreadyExistException: FanflowException(
    ErrorCode.ACCOUNT_ID_ALREADY_EXIST
)