package com.blackboxdynamics.customer.services

import com.blackboxdynamics.customer.entities.Customer

interface CustomerService {
    fun registerCustomer(customer:Customer):Customer
}