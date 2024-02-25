package com.dsm.fanflow.global.s3.exception

import com.dsm.fanflow.global.error.exception.ErrorCode
import com.dsm.fanflow.global.error.exception.FanflowException

object FileException : FanflowException(
    ErrorCode.FILE_BAD_REQUEST
) {
    val ERROR = FileException
}