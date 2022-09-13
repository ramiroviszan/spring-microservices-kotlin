package com.blackboxdynamics.customer.entities

import com.blackboxdynamics.common.NoArg
import com.blackboxdynamics.customer.services.LogicException
import java.util.regex.Pattern
import javax.persistence.*

@NoArg
@Entity
class Customer(@Id
                    @SequenceGenerator(
                        name = "customer_id_sequence",
                        sequenceName = "customer_id_sequence"
                    )
                    @GeneratedValue(
                        strategy = GenerationType.SEQUENCE,
                        generator = "customer_id_sequence"
                    )
                    var id:Long,
                    val firstName:String,
                    val lastName:String) {
    var email:String = ""
        set(value) {
            if(patternMatches(value, "^(.+)@(\\S+)$")) {
                field = value
            } else {
                throw LogicException("Email invalid")
            }
        }

    fun patternMatches(email:String, pattern:String):Boolean {
        return Pattern.compile(pattern)
            .matcher(email)
            .matches();
    }
}
