package com.dsm.fanflow.domain.place.domain

import com.dsm.fanflow.global.domain.BaseIdEntity
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Place (
    @Id
    override val id: Long

): BaseIdEntity() {
}