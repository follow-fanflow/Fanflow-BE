package com.dsm.fanflow.domain.place.presentation.dto.response

import com.dsm.fanflow.global.domain.enum.Member

data class PlaceListResponse(
    val placeListResponse: List<PlaceResponse>
) {
    data class PlaceResponse(
        val id: Long,
        val name: String,
        val explainLink: String?,
        val people: Member,
        val placeX: Double,
        val placeY: Double
    )
}