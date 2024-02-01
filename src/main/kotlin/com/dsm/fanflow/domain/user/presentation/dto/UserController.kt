package com.dsm.fanflow.domain.user.presentation.dto

import com.dsm.fanflow.domain.user.presentation.dto.request.NicknameRequest
import com.dsm.fanflow.domain.user.presentation.dto.request.PasswordRequest
import com.dsm.fanflow.domain.user.presentation.dto.request.SignInRequest
import com.dsm.fanflow.domain.user.presentation.dto.request.SignUpRequest
import com.dsm.fanflow.domain.user.service.ModifyService
import com.dsm.fanflow.domain.user.service.SignInService
import com.dsm.fanflow.domain.user.service.SignUpService
import com.dsm.fanflow.global.security.dto.response.TokenResponse
import javax.validation.Valid
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(
    private val signUpService: SignUpService,
    private val signInService: SignInService,
    private val modifyService: ModifyService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid request : SignUpRequest): TokenResponse{
        return signUpService.execute(request)
    }

    @PostMapping("/login")
    fun signIn(@RequestBody @Valid request: SignInRequest): TokenResponse{
        return signInService.execute(request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/password/{id}")
    fun password(@PathVariable @NotNull id: String, @RequestBody @Valid request: PasswordRequest){
        modifyService.password(id, request)
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/nickname/{id}")
    fun nickname(@PathVariable @NotNull id: String, @RequestBody @Valid request: NicknameRequest){
        modifyService.nickname(id, request)
    }
}