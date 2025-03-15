package com.bentfores.external.provider.server.config

import com.bentfores.external.provider.server.config.properties.JobProperties
import com.bentfores.external.provider.server.job.ProductInfoGetterJob
import org.quartz.JobBuilder
import org.quartz.JobDetail
import org.quartz.SimpleScheduleBuilder
import org.quartz.Trigger
import org.quartz.TriggerBuilder
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.Date

@Configuration
class QuartzConfig(
  private val jobProperties: JobProperties
) {

  @Bean
  @ConditionalOnProperty(
    name = ["jobs.product-info-getter.enabled"],
    havingValue = "true",
    matchIfMissing = false
  )
  fun productInfoGetterJobDetail(): JobDetail =
    JobBuilder.newJob()
      .ofType(ProductInfoGetterJob::class.java)
      .storeDurably()
      .withIdentity("PRODUCT_INFO_GETTER")
      .withDescription("Get product info from external system")
      .build()

  @Bean
  @ConditionalOnBean(name = ["productInfoGetterJobDetail"])
  fun trigger(): Trigger =
    TriggerBuilder.newTrigger()
      .forJob(productInfoGetterJobDetail())
      .withIdentity("DEFAULT_TRIGGER")
      .withDescription("Default job trigger")
      .withSchedule(
        SimpleScheduleBuilder.repeatSecondlyForever(jobProperties.productInfoGetter.fixedDelay)
      ).startAt(
        Date(
          System.currentTimeMillis() + jobProperties.productInfoGetter.initialDelayInMillis
        )
      )
      .build()
}