package com.dsm.fanflow.domain.place.service

import com.dsm.fanflow.domain.place.exception.PlaceNotFoundException
import com.dsm.fanflow.domain.place.facade.PlaceFacade
import com.dsm.fanflow.domain.user.exception.RoleIsNotAdminException
import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.global.domain.enum.Role
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PlaceDeleteService(
    private val userFacade: UserFacade,
    private val placeFacade: PlaceFacade
) {
    @Transactional
    fun delete(id: Long) {
        val user = userFacade.getUser()
        if(!placeFacade.existPlace(id)){
            throw PlaceNotFoundException.ERROR
        }
        val place = placeFacade.getPlaceById(id)

        if(user.role == Role.ADMIN) {
            placeFacade.delete(place)
        } else {
            throw RoleIsNotAdminException
        }
    }
}
