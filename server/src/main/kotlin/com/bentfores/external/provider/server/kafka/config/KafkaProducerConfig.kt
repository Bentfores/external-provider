package com.bentfores.external.provider.server.kafka.config

import com.bentfores.external.provider.ProductInfo.ProductsInfo
import com.bentfores.external.provider.server.props.SystemProperties
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaProducerConfig(
  private val kafkaProperties: KafkaProperties,
  private val systemProperties: SystemProperties,
) {

  @Bean
  fun botStartProducerFactory(): ProducerFactory<String, ProductsInfo> =
    DefaultKafkaProducerFactory(baseProducerProps())

  @Bean
  fun botStartKafkaTemplate(): KafkaTemplate<String, ProductsInfo> =
    KafkaTemplate(botStartProducerFactory())

  fun baseProducerProps() = hashMapOf(
    ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.bootstrapServers,
    ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to kafkaProperties.producer.keySerializer,
    ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to kafkaProperties.producer.valueSerializer,
    AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG to systemProperties.kafka.producer.schemaRegistryUrl,
  )
}
