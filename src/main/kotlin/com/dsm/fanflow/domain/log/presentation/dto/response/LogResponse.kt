package com.dsm.fanflow.domain.log.presentation.dto.response

import com.dsm.fanflow.domain.log.domain.group.Group

data class LogResponse(
    val id: Long,
    val title: String,
    val content: String,
    val group: String,
    val image: String
)
