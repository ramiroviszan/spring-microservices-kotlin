package com.blackboxdynamics.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@SpringBootApplication(
    scanBasePackages = [
        "com.blackboxdynamics.amqp",
        "com.blackboxdynamics.customer"
    ]
)
@EnableEurekaClient
@EnableFeignClients(
    basePackages = ["com.blackboxdynamics.clients"]
)
@PropertySources(
    value = [
        PropertySource("classpath:clients-\${spring.profiles.active}.properties")
    ]
)
class CustomerApplication

fun main(args: Array<String>) {
    runApplication<CustomerApplication>(*args)
}