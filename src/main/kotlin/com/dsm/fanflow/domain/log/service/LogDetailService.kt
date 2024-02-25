package com.dsm.fanflow.domain.log.service

import com.dsm.fanflow.domain.log.exception.LogNotExistException
import com.dsm.fanflow.domain.log.facade.LogFacade
import com.dsm.fanflow.domain.log.presentation.dto.response.LogDetailResponse
import com.dsm.fanflow.domain.log.presentation.dto.response.LogResponse
import org.springframework.stereotype.Service

@Service
class LogDetailService(
    private val logFacade: LogFacade
) {

    fun execute(id: Long): LogDetailResponse{
        if(!logFacade.existLog(id)) {
            throw LogNotExistException.ERROR
        }
        val log = logFacade.getLogById(id)

        return LogDetailResponse(
            id = log.id,
            title = log.title,
            content = log.content,
            group = log.group.toString(),
            nickname = log.user.nickname,
            likeCount = log.likeCount,
            image = log.image
        )
    }
}