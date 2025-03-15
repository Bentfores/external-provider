package com.adron.bot.manager.server.props

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "feature-toggle")
data class FeatureToggleProps(
  /**
   * Enable sending message to bot-start when saving bot record
   */
  var botStartEventEnabled: Boolean = false,

  /**
   * Enable parameters validation while creating a new bot
   */
  var botCreationValidationEnabled: Boolean = false,

  /**
   * Enable sending notification after bot creation
   */
  var botCreationNotificationEnabled: Boolean = false,

  /**
   * Enable sending notifications when bot creation fails
   */
  var botCreationErrorNotificationEnabled: Boolean = true,

  /**
   * Enable sending notification while creating a new bot
   */
  var botClosingNotificationEnabled: Boolean = true,

  /**
   * Enable sending notification when order opening executed
   */
  var openOrderExecutedNotificationEnabled: Boolean = true,

  /**
   * Enable sending notification when order closing executed
   */
  var closeOrderExecutedNotificationEnabled: Boolean = true,

  /**
   * Enable sending notification when strategy position order executed
   */
  var strategyOrderNotificationsEnabled: Boolean = true,
)