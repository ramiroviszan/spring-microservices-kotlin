package com.blackboxdynamics.customer.controllers

import com.blackboxdynamics.common.Mapper
import com.blackboxdynamics.common.lazyLogger
import com.blackboxdynamics.customer.entities.Customer
import com.blackboxdynamics.customer.models.CustomerRequest
import com.blackboxdynamics.customer.models.CustomerResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.blackboxdynamics.customer.services.CustomerService
import com.blackboxdynamics.customer.services.LogicException
import java.util.logging.Logger

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(val service: CustomerService) {

    val logger:Logger by lazyLogger()

    @PostMapping
    fun post(@RequestBody model: CustomerRequest): ResponseEntity<CustomerResponse> {
        return try {
            logger.info("new customer added $model")
            var entity:Customer = Mapper.map(model, Customer::class.java)
            entity = service.registerCustomer(entity)
            ResponseEntity(Mapper.map(entity, CustomerResponse::class.java), HttpStatus.CREATED)
        } catch (e: LogicException) {
            ResponseEntity(HttpStatus.CONFLICT)
        }
    }
}