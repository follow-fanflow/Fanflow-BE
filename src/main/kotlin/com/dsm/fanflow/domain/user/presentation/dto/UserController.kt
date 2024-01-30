package com.dsm.fanflow.domain.user.presentation.dto

import com.dsm.fanflow.domain.user.presentation.dto.request.SignInRequest
import com.dsm.fanflow.domain.user.presentation.dto.request.SignUpRequest
import com.dsm.fanflow.domain.user.service.SignInService
import com.dsm.fanflow.domain.user.service.SignUpService
import com.dsm.fanflow.global.security.dto.response.TokenResponse
import javax.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(
    private val signUpService: SignUpService,
    private val signInService: SignInService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid request : SignUpRequest): TokenResponse{
        return signUpService.execute(request)
    }

    @PostMapping("/login")
    fun signIn(@RequestBody @Valid request: SignInRequest): TokenResponse {
        return signInService.execute(request)
    }
}