package com.bentfores.external.provider.server.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "jobs")
class JobProperties {

  var productInfoGetter: JobProperty = JobProperty()

  data class JobProperty(
    var fixedDelay: Int = 30,
    var initialDelayInMillis: Int = 5,
    var enabled: Boolean = false,
    var properties: Map<String, Any> = mapOf()
  )
}