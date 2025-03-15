package com.bentfores.external.provider.server.job

import com.bentfores.analysis.service.server.external.ExternalApi
import com.bentfores.external.provider.server.config.properties.JobProperties
import com.bentfores.external.provider.server.data.repository.QuarterRepository
import com.bentfores.external.provider.server.kafka.producer.ProductInfoProducer
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.transaction.Transactional
import java.time.LocalDateTime
import com.bentfores.external.provider.server.mapper.v1.ProductMapper
import org.quartz.Job
import org.quartz.JobExecutionContext

open class ProductInfoGetterJob(
  private val externalApi: ExternalApi,
  private val quarterRepository: QuarterRepository,
  private val productInfoProducer: ProductInfoProducer,
  private val productMapper: ProductMapper
) : Job {

  @Transactional
  override fun execute(context: JobExecutionContext) {
    val timeNow = LocalDateTime.now()
    val quarter = quarterRepository.findClosestQuarterByTime(timeNow, timeNow.minusYears(1))

    if (quarter != null) {

      log.info { "Product processing has started by date: $timeNow" }

      val products = externalApi.getProductsInfo()

      productInfoProducer.send(productMapper.mapToProductsInfo(products))

      quarterRepository.update(quarter.id!!)
    } else {
      log.info { "Time now is not the processing time yet: $timeNow" }
    }
  }

  companion object {
    private val log = KotlinLogging.logger(ProductInfoGetterJob::class.simpleName!!)
  }
}