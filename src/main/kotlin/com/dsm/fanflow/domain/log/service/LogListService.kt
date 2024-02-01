package com.dsm.fanflow.domain.log.service

import com.dsm.fanflow.domain.log.domain.Log
import com.dsm.fanflow.domain.log.domain.group.Group
import com.dsm.fanflow.domain.log.domain.repository.LogRepository
import com.dsm.fanflow.domain.log.facade.LogFacade
import com.dsm.fanflow.domain.log.presentation.dto.response.LogListResponse
import com.dsm.fanflow.domain.log.presentation.dto.response.LogResponse
import com.dsm.fanflow.domain.user.facade.UserFacade
import kotlin.math.log
import org.springframework.stereotype.Service

@Service
class LogListService(
    private val logFacade: LogFacade
) {

    fun findLog(group: String): LogListResponse? {
        val logs = logFacade.getLogsByGroup(Group.valueOf(group))


        val logListResponses = logs?.map { log ->
            LogResponse(
                id = log.id,
                title = log.title,
                content = log.content,
                group = (log.group).toString(),
                image = log.image ?: ""
            )
        }

        return logListResponses?.let { LogListResponse(logList = it) }
    }

    fun findAllLogs(): LogListResponse? {
        val logs = logFacade.getAllLos()

        val logListResponses = logs?.map { log ->
            LogResponse(
                id = log.id,
                title = log.title,
                content = log.content,
                group = (log.group).toString(),
                image = log.image ?: ""
            )
        }

        return logListResponses?.let { LogListResponse(logList = it) }
    }
}