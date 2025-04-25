package com.bentfores.external.provider.server.job

import com.bentfores.external.provider.server.data.repository.DynamicConfigsRepository
import com.bentfores.external.provider.server.data.repository.QuarterRepository
import com.bentfores.external.provider.server.external.ExternalApi
import com.bentfores.external.provider.server.kafka.producer.ProductInfoProducer
import com.bentfores.external.provider.server.mapper.v1.ProductMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.transaction.Transactional
import org.quartz.Job
import org.quartz.JobExecutionContext
import java.time.LocalDateTime

open class ProductInfoGetterJob(
  private val externalApi: ExternalApi,
  private val quarterRepository: QuarterRepository,
  private val productInfoProducer: ProductInfoProducer,
  private val productMapper: ProductMapper,
  private val dynamicConfigsRepository: DynamicConfigsRepository
) : Job {

  @Transactional
  override fun execute(context: JobExecutionContext) {
    val timeNow = LocalDateTime.now()
    val quarter = quarterRepository.findClosestQuarterByTime(timeNow, timeNow.minusYears(1))

    if (quarter != null) {

      log.info { "Product processing has started by date: $timeNow" }

      val products = externalApi.getProductsInfo(dynamicConfigsRepository.findTopByOrderById().productNumber)

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