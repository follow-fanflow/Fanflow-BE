package com.dsm.fanflow.domain.log.service

import com.dsm.fanflow.domain.log.exception.LogNotExistException
import com.dsm.fanflow.domain.log.facade.LogFacade
import com.dsm.fanflow.domain.log.presentation.dto.response.LogResponse
import org.springframework.stereotype.Service

@Service
class LogDetailService(
    private val logFacade: LogFacade
) {

    fun execute(id: Long): LogResponse{
        if(!logFacade.existLog(id)) {
            throw LogNotExistException.ERROR
        }
        val log = logFacade.getLogById(id)

        return LogResponse(log.id, log.title, log.content, (log.group).toString(), log.likeCount, log.image)
    }
}