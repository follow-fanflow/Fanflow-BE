package com.dsm.fanflow.domain.log.service

import com.dsm.fanflow.domain.log.facade.LogFacade
import com.dsm.fanflow.domain.log.presentation.dto.response.LogResponse
import com.dsm.fanflow.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class LogDetailService(
    private val logFacade: LogFacade,
    private val userFacade: UserFacade
) {

    fun execute(id: Long): LogResponse{
        val log = logFacade.getLogById(id)

        return LogResponse(log.id, log.title, log.content, (log.group).toString(), log.image)
    }
}