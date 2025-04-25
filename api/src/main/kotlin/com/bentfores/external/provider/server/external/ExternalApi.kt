package com.bentfores.external.provider.server.external

import com.bentfores.external.provider.server.external.model.ExternalProductsInfo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.math.BigDecimal

interface ExternalApi {
  @GetMapping("/products/{number}")
  fun getProductsInfo(
    @PathVariable("number") number: BigDecimal
  ): List<ExternalProductsInfo> // для 1С
}