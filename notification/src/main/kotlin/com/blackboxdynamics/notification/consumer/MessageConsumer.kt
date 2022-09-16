package com.blackboxdynamics.notification.consumer

import com.blackboxdynamics.common.lazyLogger
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import java.util.logging.Logger

@Component
class MessageConsumer {

    val logger: Logger by lazyLogger()

    @RabbitListener(queues = ["\${rabbitmq.queue.notification}"])
    fun consumer(notification:String) {
        logger.info("Consumed message: $notification")
    }
}