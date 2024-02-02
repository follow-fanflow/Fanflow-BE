package com.dsm.fanflow.domain.schedule.presentation

import com.dsm.fanflow.domain.schedule.presentation.dto.request.ScheduleRequest
import com.dsm.fanflow.domain.schedule.presentation.dto.response.ReturnIdResponse
import com.dsm.fanflow.domain.schedule.service.CreateService
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/schedule")
@RestController
class ScheduleController(
    private val createService: CreateService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@RequestBody @Valid request: ScheduleRequest): ReturnIdResponse {
        return createService.execute(request)
    }
}