package com.blackboxdynamics.fraud.controllers

import com.blackboxdynamics.common.Mapper
import com.blackboxdynamics.common.lazyLogger
import com.blackboxdynamics.fraud.services.FraudService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@RequestMapping("/api/v1/frauds")
class FraudController(val service:FraudService) {

    val logger:Logger by lazyLogger()

    @GetMapping("/{customerId}")
    fun get(@PathVariable customerId:Long): ResponseEntity<Boolean> {
        logger.info("fraud check $customerId")
        val response:Boolean = service.isFraud(customerId)
        return ResponseEntity.ok(response)
    }
}