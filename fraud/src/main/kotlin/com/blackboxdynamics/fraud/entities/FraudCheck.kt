package com.blackboxdynamics.fraud.entities

import com.blackboxdynamics.common.NoArg
import java.time.LocalDateTime
import javax.persistence.*

@NoArg
@Entity
class FraudCheck(@Id
            @SequenceGenerator(
                name = "fraud_id_sequence",
                sequenceName = "fraud_id_sequence"
            )
            @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "fraud_id_sequence"
            )
            var id:Long? = null,
                 val customerId:Long,
                 val isFraud:Boolean,
                 val createdAt:LocalDateTime)
