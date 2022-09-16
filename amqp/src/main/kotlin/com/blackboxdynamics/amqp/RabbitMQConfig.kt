package com.blackboxdynamics.amqp

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
open class RabbitMQConfig(val connectionFactory: ConnectionFactory) {

    @Bean
    @Primary
    open fun amqpTemplate(): AmqpTemplate {
        val template:RabbitTemplate = RabbitTemplate(connectionFactory)
        template.messageConverter = jacksonConverter()
        return template
    }

    @Bean
    open fun jacksonConverter():MessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    open fun simpleListenerConnectionFactory():SimpleRabbitListenerContainerFactory {
        val factory:SimpleRabbitListenerContainerFactory = SimpleRabbitListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory)
        factory.setMessageConverter(jacksonConverter())
        return factory
    }
}