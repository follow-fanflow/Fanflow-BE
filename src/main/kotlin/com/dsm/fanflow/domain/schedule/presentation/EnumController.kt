package com.dsm.fanflow.domain.schedule.presentation

import com.dsm.fanflow.domain.schedule.presentation.dto.response.EnumListResponse
import com.dsm.fanflow.domain.schedule.service.ListService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/enum")
@RestController
class EnumController(
    private val listService: ListService
) {

    @GetMapping("/member")
    fun member(): EnumListResponse {
        return listService.getAllMembers()
    }
}