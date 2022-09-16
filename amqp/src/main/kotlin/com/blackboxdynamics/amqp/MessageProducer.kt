package com.blackboxdynamics.amqp

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class MessageProducer(val ampqTemplate: AmqpTemplate) {

    fun publish(payload:Any, exchange:String, routingKeys:String) {
        ampqTemplate.convertAndSend(exchange, routingKeys, payload)
    }

}