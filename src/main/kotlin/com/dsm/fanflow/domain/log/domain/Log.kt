package com.dsm.fanflow.domain.log.domain

import com.dsm.fanflow.domain.user.domain.User
import com.dsm.fanflow.global.domain.BaseIdEntity
import com.dsm.fanflow.global.domain.enum.Group
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Log(
    override val id: Long,

    val title: String,
    val content: String,
    @Column(name = "log_group")
    @Enumerated(EnumType.STRING)
    val group: Group,
    var likeCount: Int = 0,
    var approve: Boolean = false,
    var image: String? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
): BaseIdEntity() {

    fun addLike() {
        likeCount += 1
    }

    fun deleteLike() {
        likeCount -=1
    }
}