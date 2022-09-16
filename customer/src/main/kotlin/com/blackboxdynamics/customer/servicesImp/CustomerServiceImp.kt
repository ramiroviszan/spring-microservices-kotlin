package com.blackboxdynamics.customer.servicesImp

import com.blackboxdynamics.amqp.MessageProducer
import com.blackboxdynamics.clients.fraud.FraudClient
import com.blackboxdynamics.customer.entities.Customer
import com.blackboxdynamics.customer.repositories.CustomerRepository
import com.blackboxdynamics.customer.services.CustomerService
import com.blackboxdynamics.customer.services.LogicException
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CustomerServiceImp(val repository: CustomerRepository,
                         val fraudClient: FraudClient,
                         val producer:MessageProducer
) : CustomerService {

    override fun registerCustomer(customer:Customer):Customer {
        repository.saveAndFlush(customer)
        val response:Boolean = fraudClient.isFraud(customer.id)

        if(response) {
            throw LogicException("Fraud Client")
        }

        producer.publish(
            "Hello new costumer $customer",
            "internal.exchange",
            "internal.notification.routing-key"
        )
        return customer
    }
}