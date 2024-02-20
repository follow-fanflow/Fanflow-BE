package com.dsm.fanflow.domain.place.service

import com.dsm.fanflow.domain.place.domain.Place
import com.dsm.fanflow.domain.place.exception.PlaceNotFoundException
import com.dsm.fanflow.domain.place.facade.PlaceFacade
import com.dsm.fanflow.domain.place.presentation.dto.request.PlaceRequest
import com.dsm.fanflow.domain.user.exception.RoleIsNotAdminException
import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.global.domain.enum.Member
import com.dsm.fanflow.global.domain.enum.Role
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PlaceService(
    private val placeFacade: PlaceFacade,
    private val userFacade: UserFacade
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

    @Transactional
    fun approve(id: Long) {
        val user = userFacade.getUser()

        if(!placeFacade.existPlace(id)){
            throw PlaceNotFoundException.ERROR
        }
        val place = placeFacade.getPlaceById(id)

        if(user.role == Role.ADMIN) {
            place.approve = true
        } else {
            throw RoleIsNotAdminException.ERROR
        }
    }
}