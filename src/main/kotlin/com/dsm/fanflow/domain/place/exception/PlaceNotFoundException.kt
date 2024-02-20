package com.dsm.fanflow.domain.place.exception

import com.dsm.fanflow.global.error.exception.ErrorCode
import com.dsm.fanflow.global.error.exception.FanflowException

object PlaceNotFoundException: FanflowException(ErrorCode.PLACE_NOT_FOUND) {
    val ERROR = PlaceNotFoundException
}