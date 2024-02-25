package com.dsm.fanflow.domain.log.presentation.dto.response

data class LogDetailResponse (
    val id: Long,
    val nickname: String,
    val title: String,
    val content: String,
    val group: String,
    val likeCount: Int,
    val image: String?
)