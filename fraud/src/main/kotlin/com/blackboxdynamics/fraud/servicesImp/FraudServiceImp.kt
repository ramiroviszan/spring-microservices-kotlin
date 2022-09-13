package com.blackboxdynamics.fraud.servicesImp

import com.blackboxdynamics.fraud.entities.FraudCheck
import com.blackboxdynamics.fraud.repositories.FraudRepository
import com.blackboxdynamics.fraud.services.FraudService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class FraudServiceImp(val repository: FraudRepository) : FraudService {

    override fun isFraud(customerId:Long):Boolean {
        val fraudCheck = FraudCheck(null, customerId, false, LocalDateTime.now())
        repository.save(fraudCheck)
        return false;
    }
}