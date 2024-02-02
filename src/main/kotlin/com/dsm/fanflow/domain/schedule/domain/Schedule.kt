package com.dsm.fanflow.domain.schedule.domain

import com.dsm.fanflow.global.domain.BaseIdEntity
import com.dsm.fanflow.global.domain.enum.Group
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

@Entity
class Schedule(
    @Id
    override val id: Long,

    var title: String,
    var date: LocalDate,
    @Enumerated(EnumType.STRING)
    @Column(name = "schedule_group")
    var group: Group,
    var member: String?,
    var place: String?,

    ): BaseIdEntity() {
        
}