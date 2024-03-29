package com.dsm.fanflow.domain.log.service

import com.dsm.fanflow.domain.log.domain.Log
import com.dsm.fanflow.domain.log.facade.LogFacade
import com.dsm.fanflow.domain.log.presentation.dto.response.LogListResponse
import com.dsm.fanflow.domain.log.presentation.dto.response.LogResponse
import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.global.domain.enum.Group
import org.springframework.stereotype.Service

@Service
class LogListService(
    private val logFacade: LogFacade,
    private val userFacade: UserFacade
) {

    fun findLog(group: String): LogListResponse? {
        val logs = logFacade.getLogsByGroupAndApprove(Group.valueOf(group))
        val logListResponses = logs?.let { mapLogsToResponse(it) }
        return logListResponses?.let { LogListResponse(logList = it) }
    }

    fun findAllLogs(): LogListResponse? {
        val logs = logFacade.getApprovedLogs()
        val logListResponses = logs?.let { mapLogsToResponse(it) }
        return logListResponses?.let { LogListResponse(logList = it) }
    }

    fun mapLogsToResponse(logs: List<Log>): List<LogResponse> {
        return logs.map { log ->
            LogResponse(
                id = log.id,
                title = log.title,
                content = log.content,
                group = log.group.toString(),
                likeCount = log.likeCount,
                image = log.image ?: ""
            )
        }
    }
}