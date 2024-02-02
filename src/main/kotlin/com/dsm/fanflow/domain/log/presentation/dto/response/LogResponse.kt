package com.dsm.fanflow.domain.log.presentation.dto.response

data class LogResponse(
    val id: Long,
    val title: String,
    val content: String,
    val group: String,
    val likeCount: Int,
    val image: String?
)
