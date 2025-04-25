package com.bentfores.external.provider.server.kafka.producer

import com.bentfores.external.provider.ProductInfo.ProductsInfo
import com.bentfores.external.provider.server.config.properties.SystemProperties
import io.github.oshai.kotlinlogging.KotlinLogging
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ProductInfoProducer(
  private val kafkaTemplate: KafkaTemplate<String, ProductsInfo>,
  private val systemProperties: SystemProperties
) {

  fun send(message: ProductsInfo) {

    kafkaTemplate.send(
      ProducerRecord(systemProperties.kafka.topics.productInfo.name, null, null, message)
    )
  }

  companion object {
    private val log = KotlinLogging.logger(this::class.java.simpleName)
  }
}