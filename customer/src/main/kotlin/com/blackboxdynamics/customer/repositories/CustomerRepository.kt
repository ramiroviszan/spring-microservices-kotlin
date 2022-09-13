package com.blackboxdynamics.customer.repositories

import com.blackboxdynamics.customer.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {
}