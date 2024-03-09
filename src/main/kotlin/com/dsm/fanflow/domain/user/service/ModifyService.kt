package com.dsm.fanflow.domain.user.service

import com.dsm.fanflow.domain.user.facade.UserFacade
import com.dsm.fanflow.domain.user.presentation.dto.request.NicknameRequest
import com.dsm.fanflow.domain.user.presentation.dto.request.PasswordRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ModifyService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun password(id: String, request: PasswordRequest){
        val user = userFacade.getUserByAccountId(id)
        val newPW = passwordEncoder.encode(request.password)
        user.passwordChange(newPW)
    }

    @Transactional
    fun nickname(id: String, request: NicknameRequest){
        val user = userFacade.getUserByAccountId(id)
        user.nicknameChange(request.nickname)
    }
}