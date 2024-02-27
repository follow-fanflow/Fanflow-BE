package com.dsm.fanflow.domain.schedule.presentation

import com.dsm.fanflow.domain.schedule.presentation.dto.request.ScheduleRequest
import com.dsm.fanflow.domain.schedule.presentation.dto.response.ReturnIdResponse
import com.dsm.fanflow.domain.schedule.presentation.dto.response.ScheduleListResponse
import com.dsm.fanflow.domain.schedule.service.ScheduleService
import com.dsm.fanflow.domain.schedule.service.DeleteService
import com.dsm.fanflow.domain.schedule.service.ScheduleListService
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/schedule")
@RestController
class ScheduleController(
    private val scheduleService: ScheduleService,
    private val deleteService: DeleteService,
    private val listService: ScheduleListService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun create(@RequestBody @Valid request: ScheduleRequest): ReturnIdResponse {
        return scheduleService.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/admin/{id}")
    fun delete(@PathVariable @Valid id: Long) {
        deleteService.execute(id)
    }

    @PostMapping("/admin/{id}")
    fun approve(@PathVariable @Valid id: Long) {
        scheduleService.approve(id)
    }

    @GetMapping("/admin")
    fun getApproveNeedSchedule(): ScheduleListResponse? {
        return listService.findApproveNeedSchedule()
    }

    @GetMapping
    fun groupSchedule(@RequestParam(value = "group") group: String): ScheduleListResponse? {
        return listService.execute(group)
    }
}