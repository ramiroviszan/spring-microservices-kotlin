package com.blackboxdynamics.customer.config

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Deprecated("Use Feign Client Instead")
@Configuration
class CustomerConfig {

    @Bean
    @LoadBalanced
    fun restTemplate():RestTemplate{
        return RestTemplate()
    }
}