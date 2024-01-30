package com.dsm.fanflow.global.error.exception

abstract class FanflowException(
    val errorCode: ErrorCode
): RuntimeException()