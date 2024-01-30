package com.dsm.fanflow.domain.user.exception

import com.dsm.fanflow.global.error.exception.ErrorCode
import com.dsm.fanflow.global.error.exception.FanflowException

object UserNotFoundException: FanflowException(
    ErrorCode.USER_NOT_FOUND
)