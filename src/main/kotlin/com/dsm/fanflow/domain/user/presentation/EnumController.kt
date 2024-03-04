package com.dsm.fanflow.domain.schedule.presentation

import com.dsm.fanflow.domain.schedule.service.ListService
import com.dsm.fanflow.global.domain.enum.Group
import com.dsm.fanflow.global.domain.enum.Member
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/enum")
@RestController
class EnumController(
    private val listService: ListService
) {

    @GetMapping("/member")
    fun member(): List<Member> {
        return listService.getAllMembers()
    }

    @GetMapping("/group")
    fun group(): List<Group> {
        return listService.getAllGroups()
    }
}
