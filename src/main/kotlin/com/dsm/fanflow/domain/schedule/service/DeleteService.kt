package com.dsm.fanflow.domain.schedule.service

import com.dsm.fanflow.domain.schedule.domain.repository.ScheduleRepository
import com.dsm.fanflow.domain.schedule.facade.ScheduleFacade
import com.dsm.fanflow.domain.user.exception.RoleIsNotAdminException
import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.global.domain.enum.Role
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteService(
    private val scheduleRepository: ScheduleRepository,
    private val scheduleFacade: ScheduleFacade,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(id: Long) {
        var user = userFacade.getUser()
        var schedule = scheduleFacade.getScheduleById(id)

        if(user.role == Role.ADMIN) {
            scheduleRepository.delete(schedule)
        } else {
            throw RoleIsNotAdminException.ERROR
        }
    }
}