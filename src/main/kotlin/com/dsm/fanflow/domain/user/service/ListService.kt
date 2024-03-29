package com.dsm.fanflow.domain.user.service

import com.dsm.fanflow.global.domain.enum.Group
import com.dsm.fanflow.global.domain.enum.Member
import org.springframework.stereotype.Service

@Service
class ListService {
    fun getAllMembers(): List<String> {
        return Member.values().map { it.korean }.toList()
    }

    fun getAllGroups(): List<String> {
        return Group.values().map { it.name }.toList()
    }
}
