package com.bentfores.external.provider.server.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "dynamic_configs")
data class DynamicConfigs(
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.UUID)
  var id: UUID? = null,

  @Column(name = "product_number")
  var productNumber: BigDecimal = BigDecimal(300)
)
