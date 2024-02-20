package com.dsm.fanflow.domain.schedule.domain.repository

import com.dsm.fanflow.domain.schedule.domain.Schedule
import com.dsm.fanflow.global.domain.enum.Group
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScheduleRepository: JpaRepository<Schedule, Long> {
    fun findScheduleById(id: Long): Schedule
    fun findScheduleByGroupAndApprove(group: Group, approve: Boolean): List<Schedule>?
    fun findScheduleByApprove(approve: Boolean): List<Schedule>?

}