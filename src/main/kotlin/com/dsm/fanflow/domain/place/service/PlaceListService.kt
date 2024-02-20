package com.dsm.fanflow.domain.place.service

import com.dsm.fanflow.domain.place.facade.PlaceFacade
import com.dsm.fanflow.domain.place.presentation.dto.response.PlaceListResponse
import com.dsm.fanflow.global.domain.enum.Member
import org.springframework.stereotype.Service

@Service
class PlaceListService(
    private val placeFacade: PlaceFacade
) {

    fun execute(member: Member): PlaceListResponse? {
        val places = placeFacade.getPlacesByPeopleAndApprove(member)
        val placeResponseList = places?.map { place ->
            PlaceListResponse.PlaceResponse(
                id = place.id,
                name = place.name,
                explainLink = place.explainLink,
                people = place.people,
                placeX = place.placeX,
                placeY = place.placeY
            )
        }

        return placeResponseList?.let { PlaceListResponse(it) }
    }

    fun needApproveMap(): PlaceListResponse? {
        val places = placeFacade.getPlaceByApproveNeed()
        val placeResponseList = places?.map { place ->
            PlaceListResponse.PlaceResponse(
                id = place.id,
                name = place.name,
                explainLink = place.explainLink,
                people = place.people,
                placeX = place.placeX,
                placeY = place.placeY
            )
        }

        return placeResponseList?.let { PlaceListResponse(it) }
    }

}