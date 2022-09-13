package com.blackboxdynamics.clients.fraud

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    "fraud"
)
interface FraudClient {

    @GetMapping(  "api/v1/frauds/{customerId}")
    fun isFraud(@PathVariable customerId:Long):Boolean
}