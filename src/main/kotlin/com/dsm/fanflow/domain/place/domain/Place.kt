package com.dsm.fanflow.domain.place.domain

import com.dsm.fanflow.global.domain.BaseIdEntity
import com.dsm.fanflow.global.domain.enum.Member
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

@Entity
class Place (
    @Id
    override val id: Long,

    val name: String,

    val explainLink: String? = null,

    @Enumerated(EnumType.STRING)
    val people: Member,

    val placeX: Double,

    val placeY: Double,

    var approve: Boolean = false,

    ): BaseIdEntity() {
}