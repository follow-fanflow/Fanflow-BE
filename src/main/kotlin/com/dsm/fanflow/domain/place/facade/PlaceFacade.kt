package com.dsm.fanflow.domain.place.facade

import com.dsm.fanflow.domain.place.domain.Place
import com.dsm.fanflow.domain.place.domain.repository.PlaceRepository
import com.dsm.fanflow.global.domain.enum.Member
import org.springframework.stereotype.Component

@Component
class PlaceFacade(
    private val placeRepository: PlaceRepository
) {

    fun getPlacesByPeopleAndApprove(people: Member): List<Place>? {
        return placeRepository.findPlacesByPeopleAndApprove(people, true)
    }

    fun getPlacesByPeople(people: Member): List<Place>? {
        return placeRepository.findPlacesByPeople(people)
    }

    fun getPlaceById(id: Long): Place {
        return placeRepository.findPlaceById(id)
    }

    fun existPlace(id: Long): Boolean {
        return placeRepository.existsPlaceById(id)
    }

    fun save(place: Place): Long {
        placeRepository.save(place)
        return place.id
    }

    fun delete(place: Place) {
        placeRepository.delete(place)
    }
}