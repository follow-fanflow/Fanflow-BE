package com.dsm.fanflow.domain.schedule.service

import com.dsm.fanflow.domain.schedule.presentation.dto.response.EnumListResponse
import com.dsm.fanflow.global.domain.enum.Member
import org.springframework.stereotype.Service

@Service
class ListService {
    fun getAllMembers(): EnumListResponse {
        val allMembers = Member.values().map { member ->
            EnumListResponse.MemberResponse(member)
        }
        return EnumListResponse(allMembers)
    }
}