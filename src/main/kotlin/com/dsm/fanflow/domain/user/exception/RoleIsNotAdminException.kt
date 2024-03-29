package com.dsm.fanflow.domain.user.exception

import com.dsm.fanflow.global.error.exception.ErrorCode
import com.dsm.fanflow.global.error.exception.FanflowException

object RoleIsNotAdminException: FanflowException(
    ErrorCode.ROLE_NOT_ADMIN
) {
    val ERROR = RoleIsNotAdminException
}