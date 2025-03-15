package com.bentfores.analysis.service.server.external

import com.bentfores.analysis.service.server.external.model.ExternalProductsInfo
import org.springframework.web.bind.annotation.GetMapping

interface ExternalApi {
  @GetMapping("/products")
  fun getProductsInfo(): List<ExternalProductsInfo>
}