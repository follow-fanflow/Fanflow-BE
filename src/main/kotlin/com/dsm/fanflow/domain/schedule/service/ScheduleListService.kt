package com.dsm.fanflow.domain.schedule.service

import com.dsm.fanflow.domain.schedule.domain.Schedule
import com.dsm.fanflow.domain.schedule.facade.ScheduleFacade
import com.dsm.fanflow.domain.schedule.presentation.dto.response.ScheduleListResponse
import com.dsm.fanflow.domain.schedule.presentation.dto.response.ScheduleResponse
import com.dsm.fanflow.global.domain.enum.Group
import org.springframework.stereotype.Service

@Service
class ScheduleListService(
    private val scheduleFacade: ScheduleFacade
) {

    fun execute(group: String): ScheduleListResponse? {
        val schedules = scheduleFacade.getScheduleByGroupAndApprove(Group.valueOf(group))
        val scheduleResponseList = schedules?.let { mapSchedulesToResponse(it) }

        return scheduleResponseList?.let { ScheduleListResponse(it) }
    }

    fun findApproveNeedLog(): ScheduleListResponse? {
        val schedules = scheduleFacade.getApproveNeedLogs()
        val scheduleResponseList = schedules?.let { mapSchedulesToResponse(it) }
        return scheduleResponseList?.let { ScheduleListResponse(scheduleList = it) }
    }

    fun mapSchedulesToResponse(schedules: List<Schedule>): List<ScheduleResponse> {
        return schedules.map { schedule ->
            ScheduleResponse(
                id = schedule.id,
                title = schedule.title,
                date = schedule.date,
                group = schedule.group,
                member = schedule.member,
                place = schedule.place
            )
        }
    }
}