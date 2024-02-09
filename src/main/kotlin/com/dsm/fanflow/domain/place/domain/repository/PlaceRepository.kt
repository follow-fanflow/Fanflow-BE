package com.dsm.fanflow.domain.place.domain.repository

import com.dsm.fanflow.domain.place.domain.Place
import com.dsm.fanflow.global.domain.enum.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaceRepository : JpaRepository<Place, Long> {
    fun findPlacesByPeopleAndApprove(people: Member, approve: Boolean): List<Place>?
    fun findPlacesByPeople(people: Member): List<Place>?
    fun findPlaceById(id: Long): Place
    fun existsPlaceById(id: Long): Boolean
}