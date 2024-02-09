package com.dsm.fanflow.domain.place.presentation

import com.dsm.fanflow.domain.place.presentation.dto.request.PlaceRequest
import com.dsm.fanflow.domain.place.service.PlaceService
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/place")
@RestController
class PlaceController(
    private val placeService: PlaceService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createPlace(@RequestBody @Valid request: PlaceRequest): Long{
        return placeService.save(request)
    }
}