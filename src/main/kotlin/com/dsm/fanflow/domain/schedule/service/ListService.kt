package com.dsm.fanflow.domain.schedule.service

import com.dsm.fanflow.global.domain.enum.Group
import com.dsm.fanflow.global.domain.enum.Member
import org.springframework.stereotype.Service

@Service
class ListService {
    fun getAllMembers(): List<Member> {
        return Member.values().map { it }.toList()
    }

    fun getAllGroups(): List<Group> {
        return Group.values().map { it }.toList()
    }
}