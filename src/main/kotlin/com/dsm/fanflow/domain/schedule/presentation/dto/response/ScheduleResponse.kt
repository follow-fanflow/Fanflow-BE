package com.dsm.fanflow.domain.schedule.presentation.dto.response

import com.dsm.fanflow.global.domain.enum.Group
import java.time.LocalDate

data class ScheduleResponse(
    val id: Long,
    val title: String,
    val date: LocalDate,
    val group: Group,
    val member: String?,
    val place: String?
)
