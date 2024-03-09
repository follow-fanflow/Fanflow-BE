package com.dsm.fanflow.domain.user.facade

import com.dsm.fanflow.domain.user.domain.User
import com.dsm.fanflow.domain.user.domain.repository.UserRepository
import com.dsm.fanflow.domain.user.exception.TokenUnauthorizedException
import com.dsm.fanflow.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun checkAccountIdExist(accountId: String): Boolean {
        return userRepository.existsByAccountId(accountId)
    }

    fun getUserId(): String? {
        val authentication =
            SecurityContextHolder.getContext().authentication ?: throw TokenUnauthorizedException()
        return authentication.name
    }

    fun getUser(): User {
        return userRepository.findByAccountId(getUserId()!!)!!
    }


    fun getUserByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }
}