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
data class User(

    @Column(nullable = false, length = 20, unique = true)
    @Id
    val accountId: String,

    @Column(length = 12, nullable = false)
    val nickname: String,

    @Column(length = 60, nullable = false)
    val password: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val role: Role = Role.USER,

    val profileImg: String? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.REMOVE], orphanRemoval = true)
    val myLogs: MutableList<Log> = mutableListOf()

)
