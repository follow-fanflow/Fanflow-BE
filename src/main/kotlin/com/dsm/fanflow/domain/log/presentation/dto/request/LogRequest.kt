package com.dsm.fanflow.domain.log.presentation.dto.request

import com.dsm.fanflow.global.domain.enum.Group
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class LogRequest(
    @field:NotBlank
    @field:Size(min = 2, max = 15)
    val title: String,

    @field:NotBlank
    @field:Size(min = 2, max = 5000)
    val content: String,

    val group: Group
)