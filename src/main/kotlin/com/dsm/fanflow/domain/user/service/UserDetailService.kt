package com.dsm.fanflow.domain.user.service

import com.dsm.fanflow.domain.log.facade.LogFacade
import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.domain.user.presentation.dto.response.UserDetailResponse
import org.springframework.stereotype.Service

@Service
class UserDetailService(
    private val userFacade: UserFacade,
    private val logFacade: LogFacade
) {

    fun myPage(): UserDetailResponse {
        val user = userFacade.getUser()

        val logsCount = logFacade.getLogsByUser(user)!!.size

        return UserDetailResponse(
            userId = user.accountId,
            nickname = user.nickname,
            logsInt = logsCount
        )
    }
}