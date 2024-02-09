package com.dsm.fanflow.domain.log.facade

import com.dsm.fanflow.domain.log.domain.Log
import com.dsm.fanflow.domain.log.domain.repository.LogRepository
import com.dsm.fanflow.domain.user.domain.User
import com.dsm.fanflow.global.domain.enum.Group
import org.springframework.stereotype.Component

@Component
class LogFacade(
    private val logRepository: LogRepository
) {

    fun getLogsByGroupAndApprove(group: Group): List<Log>? {
        return logRepository.findLogsByGroupAndAndApprove(group, true)
    }

    fun getLogById(id: Long): Log {
        return logRepository.findLogById(id)
    }

    fun existLog(id: Long): Boolean {
        return logRepository.existsLogById(id)
    }

    fun getApprovedLogs(): List<Log>? {
        return logRepository.findLogsByApprove(true)
    }

    fun getLogsByUser(user: User): List<Log>? {
        return logRepository.findLogsByUser(user)
    }

}