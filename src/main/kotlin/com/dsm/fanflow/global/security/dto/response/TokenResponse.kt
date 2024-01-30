package com.dsm.fanflow.global.security.dto.response

data class TokenResponse (
    val accessToken: String,
    val refreshToken: String
)