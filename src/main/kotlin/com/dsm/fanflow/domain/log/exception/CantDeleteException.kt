package com.dsm.fanflow.domain.log.exception

import com.dsm.fanflow.global.error.exception.ErrorCode
import com.dsm.fanflow.global.error.exception.FanflowException

object CantDeleteException: FanflowException(
    ErrorCode.CANT_DELETE_LOG
) {
    val ERROR = CantDeleteException
}