package com.dsm.fanflow.domain.schedule.service

import com.dsm.fanflow.domain.schedule.domain.Schedule
import com.dsm.fanflow.domain.schedule.domain.repository.ScheduleRepository
import com.dsm.fanflow.domain.schedule.facade.ScheduleFacade
import com.dsm.fanflow.domain.schedule.presentation.dto.request.ScheduleRequest
import com.dsm.fanflow.domain.schedule.presentation.dto.response.ReturnIdResponse
import com.dsm.fanflow.domain.user.exception.RoleIsNotAdminException
import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.global.domain.enum.Role
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ScheduleService(
    private val scheduleRepository: ScheduleRepository,
    private val scheduleFacade: ScheduleFacade,
    private val userFacade: UserFacade
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

    @Transactional
    fun approve(id: Long) {
        var schedule = scheduleFacade.getScheduleById(id)
        var user = userFacade.getUser()

        if(user.role == Role.ADMIN) {
            schedule.approve = true
        } else {
            throw RoleIsNotAdminException.ERROR
        }

    }
}