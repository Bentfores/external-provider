package com.bentfores.external.provider.server.data.repository

import com.bentfores.external.provider.server.data.entity.DynamicConfigs
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DynamicConfigsRepository : JpaRepository<DynamicConfigs, UUID> {

  fun findTopByOrderById(): DynamicConfigs
}