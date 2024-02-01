package com.dsm.fanflow.domain.user.exception

import com.dsm.fanflow.global.error.exception.ErrorCode
import com.dsm.fanflow.global.error.exception.FanflowException

class TokenUnauthorizedException: FanflowException(
    ErrorCode.TOKEN_UNAUTHORIZED
)