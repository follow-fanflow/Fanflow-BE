package com.dsm.fanflow.domain.user.service

import com.dsm.fanflow.domain.user.domain.User
import com.dsm.fanflow.domain.user.domain.repository.UserRepository
import com.dsm.fanflow.domain.user.exception.AccountIdAlreadyExistException
import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.domain.user.presentation.dto.request.SignUpRequest
import com.dsm.fanflow.global.security.dto.response.TokenResponse
import com.dsm.fanflow.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpService(
    private val userRepository: UserRepository,
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val jwtProvider: JwtTokenProvider


) {
    @Transactional
    fun execute(request: SignUpRequest): TokenResponse{
        print("------------------------------${request.accountId}---------------------")
        checkIdExist(request)
        val user: User = userRepository.save(
            User(
                accountId =  request.accountId,
                nickname = request.nickname,
                password = passwordEncoder.encode(request.password))
        )

        return jwtProvider.generateToken(user.accountId)
    }

    private fun checkIdExist(request: SignUpRequest) {
        if (userFacade.checkAccountIdExist(request.accountId)) {
            throw AccountIdAlreadyExistException
        }
    }
}