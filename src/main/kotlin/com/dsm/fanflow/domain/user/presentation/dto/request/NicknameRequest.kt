package com.dsm.fanflow.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class NicknameRequest(
    @field:NotBlank
    @field:Size(min = 2, max = 20)
    val nickname: String
)
