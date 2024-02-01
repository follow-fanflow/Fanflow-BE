package com.dsm.fanflow.domain.log.domain
import com.dsm.fanflow.domain.log.domain.group.Group
import com.dsm.fanflow.domain.user.domain.User
import com.dsm.fanflow.global.BaseIdEntity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
@Entity
class Log(
    override val id: Long , // 부모 클래스에서 상속받은 id 필드

    var title: String,
    var content: String,
    @Column(name = "log_group")
    @Enumerated(EnumType.STRING)
    var group: Group,
    private var likeCount: Int = 0,
    var image: String? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
): BaseIdEntity() {

    fun addLike() {
        likeCount += 1
    }

    fun modify(title: String, content: String, group: String) {
        this.title = title
        this.content = content
        this.group = Group.valueOf(group)
    }
}