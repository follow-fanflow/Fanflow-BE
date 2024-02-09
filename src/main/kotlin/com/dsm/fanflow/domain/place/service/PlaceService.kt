package com.dsm.fanflow.domain.place.service

import com.dsm.fanflow.domain.place.domain.Place
import com.dsm.fanflow.domain.place.facade.PlaceFacade
import com.dsm.fanflow.domain.place.presentation.dto.request.PlaceRequest
import com.dsm.fanflow.global.domain.enum.Member
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PlaceService(
    private val placeFacade: PlaceFacade
) {

    @Transactional
    fun save(request: PlaceRequest): Long {
        return placeFacade.save(
            Place(
                id = 0,
                name = request.name,
                explainLink = request.explainLink,
                people = Member.valueOf(request.people),
                placeX = request.placeX,
                placeY = request.placeY
            )
        )
    }
}