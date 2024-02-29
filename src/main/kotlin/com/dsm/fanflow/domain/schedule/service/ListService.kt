package com.dsm.fanflow.domain.schedule.service

import com.dsm.fanflow.domain.schedule.presentation.dto.response.EnumLitResponse
import com.dsm.fanflow.global.domain.enum.Member
import org.springframework.stereotype.Service

@Service
class ListService {
    fun getAllMembers(): EnumLitResponse {
        val allMembers = Member.values().map { member ->
            EnumLitResponse.MemberResponse(member)
        }
        return EnumLitResponse(allMembers)
    }
}