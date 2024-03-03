package com.dsm.fanflow.domain.user.domain

import com.dsm.fanflow.global.domain.enum.Role
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

@Entity
class User(
    @Column(name = "id", unique = true)
    @Id
    val accountId: String,

    @Enumerated(EnumType.STRING)
    val role: Role = Role.USER,

    val profileImg: String? = null,

    var nickname: String,
    var password: String
) {
    fun passwordChange(newPassword: String) {
        this.password = newPassword
    }

    fun nicknameChange(newNickname: String) {
        this.nickname = newNickname
    }
}

