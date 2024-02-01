package com.dsm.fanflow.domain.log.domain.repository

import com.dsm.fanflow.domain.log.domain.Log
import com.dsm.fanflow.domain.log.domain.group.Group
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LogRepository: JpaRepository<Log, Long> {
    fun findLogsByUser(userId: UUID): List<Log>?
    fun findLogsByGroup(group: Group): List<Log>?
    fun findLogById(id: Long): Log
    fun existsLogById(id: Long): Boolean
}