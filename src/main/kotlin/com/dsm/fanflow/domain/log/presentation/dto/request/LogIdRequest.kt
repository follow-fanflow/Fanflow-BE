package com.dsm.fanflow.domain.log.presentation.dto.request

import javax.validation.constraints.NotBlank

data class LogIdRequest(
    @field:NotBlank
    val id: Long
)
