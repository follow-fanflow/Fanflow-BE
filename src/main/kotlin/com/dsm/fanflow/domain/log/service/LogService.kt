package com.dsm.fanflow.domain.log.service

import com.dsm.fanflow.domain.log.domain.Log
import com.dsm.fanflow.domain.log.domain.group.Group
import com.dsm.fanflow.domain.log.domain.repository.LogRepository
import com.dsm.fanflow.domain.log.facade.LogFacade
import com.dsm.fanflow.domain.log.presentation.dto.request.LogRequest
import com.dsm.fanflow.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LogService(
    private val logRepository: LogRepository,
    private val logFacade: LogFacade,
    private val userFacade: UserFacade
) {

    @Transactional
    fun execute(request: LogRequest){
        logRepository.save(
            Log(
                id = 0,
                title = request.title,
                content = request.content,
                group = Group.valueOf(request.group),
                user = userFacade.getUser()
            )
        )
    }

    @Transactional
    fun addLike(id: Long){
        val log = logFacade.getLogById(id)
        log.addLike()
    }
}