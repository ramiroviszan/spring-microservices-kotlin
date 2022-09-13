package com.blackboxdynamics.customer.servicesImp

import com.blackboxdynamics.clients.fraud.FraudClient
import com.blackboxdynamics.customer.entities.Customer
import com.blackboxdynamics.customer.repositories.CustomerRepository
import com.blackboxdynamics.customer.services.CustomerService
import com.blackboxdynamics.customer.services.LogicException
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CustomerServiceImp(val repository: CustomerRepository,
                         val fraudClient: FraudClient
) : CustomerService {

    override fun registerCustomer(customer:Customer):Customer {
        repository.saveAndFlush(customer)
        val response:Boolean = fraudClient.isFraud(customer.id)

        if(response) {
            throw LogicException("Fraud Client")
        }
        return customer
    }
}