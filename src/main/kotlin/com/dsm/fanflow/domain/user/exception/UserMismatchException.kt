package com.dsm.fanflow.domain.user.exception

import com.dsm.fanflow.global.error.exception.ErrorCode
import com.dsm.fanflow.global.error.exception.FanflowException

object UserMismatchException: FanflowException(
    ErrorCode.USER_MISMATCH
) {
    val ERROR = UserMismatchException
}