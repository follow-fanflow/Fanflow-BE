package com.dsm.fanflow.global.security.domain

import javax.validation.constraints.NotBlank
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed


@RedisHash(value = "RefreshToken", timeToLive = 60 * 60 * 2)
class RefreshToken (
    @Id
    val id: String,

    @Indexed
    val token: String,

    @Indexed
    @field:NotBlank
    val ttl: Long
)