package com.dsm.fanflow.domain.schedule.presentation.dto.request

import com.dsm.fanflow.global.domain.enum.Group
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class ScheduleRequest(
    @field:NotBlank
    @field:Size(min = 2, max = 20)
    val title: String,

    val date: LocalDate,
    val group: Group,
    val member: String?,
    val place: String?,
)
