package com.bentfores.external.provider.server.external.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class ExternalProductsInfo(
  @JsonProperty("article", required = true) val article: String,
  @JsonProperty("name") val name: String,
  @JsonProperty("imageUrl", required = true) val imageUrl: String,
  @JsonProperty("profitPlace", required = true) val profitPlace: BigDecimal,
)
