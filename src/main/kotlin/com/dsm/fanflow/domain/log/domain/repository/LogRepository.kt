package com.dsm.fanflow.domain.log.domain.repository

import com.dsm.fanflow.domain.log.domain.Log
import com.dsm.fanflow.domain.user.domain.User
import com.dsm.fanflow.global.domain.enum.Group
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LogRepository: JpaRepository<Log, Long> {
    fun findLogsByUser(userId: User): List<Log>?
    fun findLogsByGroupAndAndApprove(group: Group, approve: Boolean ): List<Log>?
    fun findLogById(id: Long): Log
    fun existsLogById(id: Long): Boolean
    fun findLogsByApprove(approve: Boolean): List<Log>?
}