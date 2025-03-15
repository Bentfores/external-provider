package com.bentfores.external.provider.server.feign

import org.apache.logging.log4j.util.Strings
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "api.external")
data class FeignProperties(
  var externalUrl: String = Strings.EMPTY
)