package com.dsm.fanflow.domain.schedule.service

import com.dsm.fanflow.domain.schedule.domain.Schedule
import com.dsm.fanflow.domain.schedule.domain.repository.ScheduleRepository
import com.dsm.fanflow.domain.schedule.facade.ScheduleFacade
import com.dsm.fanflow.domain.schedule.presentation.dto.request.ScheduleRequest
import com.dsm.fanflow.domain.schedule.presentation.dto.response.ReturnIdResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateService(
    private val scheduleRepository: ScheduleRepository
) {

    @Transactional
    fun execute(request: ScheduleRequest): ReturnIdResponse {
        var schedule = scheduleRepository.save(
            Schedule(
                id = 0,
                title = request.title,
                date = request.date,
                group = request.group,
                member = request.member,
                place = request.place
            )
        )
        return ReturnIdResponse(schedule.id)
    }
}