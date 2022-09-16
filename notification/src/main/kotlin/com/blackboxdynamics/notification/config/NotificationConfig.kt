package com.blackboxdynamics.notification.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
data class NotificationConfig(
    @Value("\${rabbitmq.exchanges.internal}")
    val internalExchange:String,
    @Value("\${rabbitmq.queue.notification}")
    val notificationQueue:String,
    @Value("\${rabbitmq.routing-keys.internal-notification}")
    val internalNotificationRoutingKeys:String
) {

    @Bean
    fun internalExchange():TopicExchange {
        return TopicExchange(internalExchange)
    }

    @Bean
    fun notificationQueue():Queue {
        return Queue(notificationQueue)
    }

    @Bean
    fun internalToNotificationBinding(): Binding {
        return BindingBuilder
            .bind(notificationQueue())
            .to(internalExchange())
            .with(internalNotificationRoutingKeys)
    }
}