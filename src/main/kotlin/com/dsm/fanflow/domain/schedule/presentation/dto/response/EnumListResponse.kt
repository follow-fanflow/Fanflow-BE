package com.dsm.fanflow.domain.schedule.presentation.dto.response

import com.dsm.fanflow.global.domain.enum.Member

data class EnumListResponse(
    val memberListResponse: List<MemberResponse>
) {

    data class MemberResponse(
        private val member: Member
    )
}