package com.dsm.fanflow.domain.user.facade

import com.dsm.fanflow.domain.user.domain.User
import com.dsm.fanflow.domain.user.domain.repository.UserRepository
import com.dsm.fanflow.domain.user.exception.UserNotFoundException
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {

    fun checkAccountIdExist(accountId: String): Boolean {
        return userRepository.existsByAccountId(accountId)
    }

    fun checkNicknameExist(nickname: String): Boolean {
        return userRepository.existsByNickname(nickname)
    }

    fun getUserByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException
    }
}