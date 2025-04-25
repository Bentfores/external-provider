package com.bentfores.external.provider.server.service.v1

import com.bentfores.external.provider.server.data.repository.DynamicConfigsRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ExternalServiceV1(
  private val dynamicConfigsRepository: DynamicConfigsRepository
) {

  fun changeProductNumber(number: BigDecimal) {
    dynamicConfigsRepository.save(
      dynamicConfigsRepository.findTopByOrderById()
        .apply {
          productNumber = number
        }
    )
  }

}

