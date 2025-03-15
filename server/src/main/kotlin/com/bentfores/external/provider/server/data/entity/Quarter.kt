package com.bentfores.external.provider.server.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "quarter")
data class Quarter(
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  var id: UUID? = null,

  @Column(name = "time")
  var time: LocalDateTime,

  @Column(name = "updated_at")
  var updatedAt: LocalDateTime
)
