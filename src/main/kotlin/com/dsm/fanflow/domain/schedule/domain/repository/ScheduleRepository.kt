package com.dsm.fanflow.domain.schedule.domain.repository

import com.dsm.fanflow.domain.schedule.domain.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScheduleRepository: JpaRepository<Schedule, Long> {
}