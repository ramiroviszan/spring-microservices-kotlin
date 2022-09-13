package com.blackboxdynamics.fraud.services

interface FraudService {
    fun isFraud(customerId:Long):Boolean
}