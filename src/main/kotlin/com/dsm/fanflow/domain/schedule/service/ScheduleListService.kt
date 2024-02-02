package com.dsm.fanflow.domain.schedule.service

import com.dsm.fanflow.domain.schedule.domain.repository.ScheduleRepository
import com.dsm.fanflow.domain.schedule.facade.ScheduleFacade
import com.dsm.fanflow.domain.schedule.presentation.dto.response.ScheduleListResponse
import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.global.domain.enum.Group
import org.springframework.stereotype.Service

@Service
class ScheduleListService(
    private val scheduleRepository: ScheduleRepository,
    private val scheduleFacade: ScheduleFacade,
    private val userFacade: UserFacade
) {

    fun execute(group: String): ScheduleListResponse? {
        val schedules = scheduleFacade.getScheduleByGroupAndApprove(Group.valueOf(group))
        val scheduleResponseList = schedules?.map { schedule ->
            ScheduleListResponse.ScheduleResponse(
                id = schedule.id,
                title = schedule.title,
                date = schedule.date,
                group = schedule.group,
                member = schedule.member,
                place = schedule.place
            )
        }

        return scheduleResponseList?.let { ScheduleListResponse(it) }
    }
}