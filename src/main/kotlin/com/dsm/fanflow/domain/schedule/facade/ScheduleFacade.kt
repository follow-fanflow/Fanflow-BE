package com.dsm.fanflow.domain.schedule.facade

import com.dsm.fanflow.domain.schedule.domain.repository.ScheduleRepository
import org.springframework.stereotype.Component

@Component
class ScheduleFacade(
    private val scheduleRepository: ScheduleRepository
) {
}