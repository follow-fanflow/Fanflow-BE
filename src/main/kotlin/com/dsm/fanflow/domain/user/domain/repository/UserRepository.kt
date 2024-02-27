package com.dsm.fanflow.domain.user.domain.repository

import com.dsm.fanflow.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, String>{
    fun findByAccountId(accountId: String): User?
    fun existsByAccountId(accountId: String): Boolean
}