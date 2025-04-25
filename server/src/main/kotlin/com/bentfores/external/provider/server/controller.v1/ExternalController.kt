package com.bentfores.external.provider.server.controller.v1

import com.bentfores.external.provider.server.service.v1.ExternalServiceV1
import com.bentfores.external.provider.api.v1.ExternalApi
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
class ExternalController(
  private val externalServiceV1: ExternalServiceV1
) : ExternalApi {

  override fun changeProductNumberByPost(number: BigDecimal): ResponseEntity<Unit> {
    externalServiceV1.changeProductNumber(number)
    return ResponseEntity.status(200).build()
  }

}