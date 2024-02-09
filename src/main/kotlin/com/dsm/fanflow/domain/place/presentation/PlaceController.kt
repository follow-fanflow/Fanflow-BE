package com.dsm.fanflow.domain.place.presentation

import com.dsm.fanflow.domain.place.presentation.dto.request.PlaceRequest
import com.dsm.fanflow.domain.place.presentation.dto.response.PlaceListResponse
import com.dsm.fanflow.domain.place.service.PlaceDeleteService
import com.dsm.fanflow.domain.place.service.PlaceListService
import com.dsm.fanflow.domain.place.service.PlaceService
import com.dsm.fanflow.global.domain.enum.Member
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/place")
@RestController
class PlaceController(
    private val placeService: PlaceService,
    private val placeDeleteService: PlaceDeleteService,
    private val placeListService: PlaceListService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createPlace(@RequestBody @Valid request: PlaceRequest): Long{
        return placeService.save(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun deletePlace(@PathVariable @Valid id: Long) {
        placeDeleteService.delete(id)
    }

    @GetMapping
    fun findPlaceByMember(@RequestParam(value = "member") member: Member): PlaceListResponse? {
        return placeListService.execute(member)
    }

    @PostMapping("/admin/{id}")
    fun approve(@PathVariable @Valid id: Long) {
        placeService.approve(id)
    }
}