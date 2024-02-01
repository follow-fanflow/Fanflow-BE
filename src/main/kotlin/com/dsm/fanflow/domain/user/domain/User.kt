package com.dsm.fanflow.domain.user.domain

import com.dsm.fanflow.domain.log.domain.Log
import com.dsm.fanflow.domain.user.domain.role.Role
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class User(
    @Column(name = "id", unique = true)
    @Id
    val accountId: String,

    @Enumerated(EnumType.STRING)
    val role: Role = Role.USER,

    val profileImg: String? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.REMOVE], orphanRemoval = true)
    val myLogs: MutableList<Log> = mutableListOf(),

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

