package com.dsm.fanflow.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SignUpRequest(
    @field:NotBlank
    @field:Size(min = 2, max = 20)
    val accountId: String,

    @field:NotBlank
    @field:Size(min = 2, max = 20)
    val nickname: String,

    @field:NotBlank
    @field:Size(min = 8, max = 20)
    val password: String
)