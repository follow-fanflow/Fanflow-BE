package com.dsm.fanflow.domain.user.service

import com.dsm.fanflow.domain.user.exception.PasswordMismatchException
import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.domain.user.presentation.dto.request.SignInRequest
import com.dsm.fanflow.global.security.dto.response.TokenResponse
import com.dsm.fanflow.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignInService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtTokenProvider
) {
    @Transactional
    fun execute(request: SignInRequest): TokenResponse{
        val user = userFacade.getUserByAccountId(request.accountId)
        if(!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordMismatchException
        }

        return jwtProvider.generateToken(user.accountId)
    }
}