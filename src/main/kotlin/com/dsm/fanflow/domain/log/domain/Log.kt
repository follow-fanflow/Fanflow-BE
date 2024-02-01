package com.dsm.fanflow.domain.log.domain
import com.dsm.fanflow.domain.log.domain.group.Group
import com.dsm.fanflow.domain.user.domain.User
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Log(
    @Id
    val id: UUID,

    var title: String,
    var content: String,
    @Enumerated(EnumType.STRING)
    var group: Group,
    private var like: Int = 0,
    var image: String? = null,

    @ManyToOne
    @JoinColumn(name = "user_accountId")
    val user: User
) {
    fun addLike() {
        like+=1
    }
}
