package com.dsm.fanflow.domain.place.presentation.dto.request

import javax.validation.constraints.NotBlank

data class PlaceRequest(
    @field:NotBlank
    val name: String,

    val explainLink: String?,

    val people: String,

    val placeX: Double,

    val placeY: Double
)
