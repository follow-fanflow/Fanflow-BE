package com.dsm.fanflow.domain.log.service

import com.dsm.fanflow.domain.log.domain.repository.LogRepository
import com.dsm.fanflow.domain.log.exception.CantDeleteException
import com.dsm.fanflow.domain.log.facade.LogFacade
import com.dsm.fanflow.domain.log.presentation.dto.request.LogRequest
import com.dsm.fanflow.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LogDeleteService(
    private val logRepository: LogRepository,
    private val logFacade: LogFacade,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(id: Long){
        val log = logFacade.getLogById(id)
        val user = userFacade.getUser()

        if(log.user != user) {
            throw CantDeleteException.ERROR
        }
        logRepository.delete(log)
    }
}