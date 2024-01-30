package com.dsm.fanflow.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class SignInRequest(
    @field: NotBlank
    val accountId: String,

    @field: NotBlank
    val password: String
)