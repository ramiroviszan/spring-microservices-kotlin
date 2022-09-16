package com.blackboxdynamics.notification.config

import com.blackboxdynamics.amqp.MessageProducer
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@SpringBootApplication(
    scanBasePackages = [
        "com.blackboxdynamics.notification",
        "com.blackboxdynamics.amqp"
    ]
)
class NotificationApplication

fun main(args: Array<String>) {
    runApplication<NotificationApplication>(*args)
}


//@Component
//class CommandExample(val producer: MessageProducer,
//                    val notificationConfig: NotificationConfig)
//    : CommandLineRunner {
//
//    override fun run(vararg args: String?) {
//        producer.publish("foo",
//            notificationConfig.internalExchange,
//            notificationConfig.internalNotificationRoutingKeys)
//    }
//}

