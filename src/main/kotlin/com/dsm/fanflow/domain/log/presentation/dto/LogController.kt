package com.dsm.fanflow.domain.log.presentation.dto

import com.dsm.fanflow.domain.log.presentation.dto.request.LogIdRequest
import com.dsm.fanflow.domain.log.presentation.dto.request.LogRequest
import com.dsm.fanflow.domain.log.presentation.dto.response.ReturnIdResponse
import com.dsm.fanflow.domain.log.service.LogService
import java.util.UUID
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/log")
@RestController
class LogController(
    private val logService: LogService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createLog(@RequestBody @Valid request: LogRequest) {
        logService.create(request)
    }

    @PostMapping("/like/{id}")
    fun addLike(@PathVariable @Valid id: Long) {
        logService.addLike(id)
    }
}