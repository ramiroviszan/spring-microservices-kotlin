package com.blackboxdynamics.fraud.repositories

import com.blackboxdynamics.fraud.entities.FraudCheck
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FraudRepository : JpaRepository<FraudCheck, Long> {
}