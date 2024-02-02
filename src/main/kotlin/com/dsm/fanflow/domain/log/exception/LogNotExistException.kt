package com.dsm.fanflow.domain.log.exception

import com.dsm.fanflow.global.error.exception.ErrorCode
import com.dsm.fanflow.global.error.exception.FanflowException

object LogNotExistException: FanflowException(
    ErrorCode.LOG_NOT_EXIST
) {
    val ERROR = LogNotExistException
}