package com.dsm.fanflow.domain.log.service

import com.dsm.fanflow.domain.log.exception.LogNotExistException
import com.dsm.fanflow.domain.log.facade.LogFacade
import com.dsm.fanflow.domain.user.exception.UserMismatchException
import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.global.s3.S3Util
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class LogFileService(
    private val s3Util: S3Util,
    private val logFacade: LogFacade,
    private val userFacade: UserFacade
) {
    fun execute(id: Long, file: MultipartFile): String {
        val user = userFacade.getUser()

        if (!logFacade.existLog(id)) throw LogNotExistException.ERROR
        val log = logFacade.getLogById(id)

        if (log.user != user) throw UserMismatchException.ERROR
        log.image = s3Util.upload(file, "log")

        logFacade.save(log)
        return log.image!!
    }

}