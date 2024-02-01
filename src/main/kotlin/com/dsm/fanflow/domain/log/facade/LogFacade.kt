package com.dsm.fanflow.domain.log.facade

import com.dsm.fanflow.domain.log.domain.Log
import com.dsm.fanflow.domain.log.domain.group.Group
import com.dsm.fanflow.domain.log.domain.repository.LogRepository
import java.util.UUID
import kotlin.math.log
import org.springframework.stereotype.Component

@Component
class LogFacade(
    private val logRepository: LogRepository
) {

    fun getLogsByUser(userId: UUID): List<Log>? {
        return logRepository.findLogsByUser(userId)
    }

    fun getLogsByGroup(group: Group): List<Log>? {
        return logRepository.findLogsByGroup(group)
    }

    fun getLogById(id: Long): Log {
        return logRepository.findLogById(id)
    }

    fun existLog(id: Long): Boolean {
        return logRepository.existsLogById(id)
    }
}