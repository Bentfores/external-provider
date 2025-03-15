package com.bentfores.external.provider.server.data.repository

import com.bentfores.external.provider.server.data.entity.Quarter
import java.time.LocalDateTime
import java.util.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface QuarterRepository : JpaRepository<Quarter, UUID> {

  @Query(
    """
      select q from Quarter q
      where q.time <= :timeNow
        and q.updatedAt <= :yearBefore 
    """
  )
  fun findClosestQuarterByTime(timeNow: LocalDateTime, yearBefore: LocalDateTime): Quarter?

  @Modifying
  @Query(
    """
      update Quarter q
      set q.updatedAt = CURRENT_TIMESTAMP
      where q.id <= :id
    """
  )
  fun update(id: UUID)
}