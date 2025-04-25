package com.bentfores.external.provider.server.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "system")
class SystemProperties(
  var kafka: KafkaBlock = KafkaBlock()
) {

  class KafkaBlock(
    var topics: TopicsBlock = TopicsBlock(),
    var producer: ProducerBlock = ProducerBlock()
  )

  data class TopicsBlock(
    var productInfo: TopicBlock = TopicBlock()
  )

  data class ProducerBlock(
    var schemaRegistryUrl: String = "",
  )

  data class TopicBlock(
    var name: String = "",
    var protobufValueType: String = "",
  )
}