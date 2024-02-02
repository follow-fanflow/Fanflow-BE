package com.dsm.fanflow.domain.schedule.facade

import com.dsm.fanflow.domain.schedule.domain.Schedule
import com.dsm.fanflow.domain.schedule.domain.repository.ScheduleRepository
import com.dsm.fanflow.global.domain.enum.Group
import org.springframework.stereotype.Component

@Component
class ScheduleFacade(
    private val scheduleRepository: ScheduleRepository
) {

    fun getScheduleById(id: Long): Schedule {
        return scheduleRepository.findScheduleById(id)
    }

    fun getScheduleByGroupAndApprove(group: Group): List<Schedule>? {
        return scheduleRepository.findScheduleByGroupAndApprove(group, true)
    }
}