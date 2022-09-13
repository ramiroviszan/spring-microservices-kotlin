package com.blackboxdynamics.customer.models

import com.blackboxdynamics.common.NoArg

@NoArg
data class CustomerResponse(val id:Long,
                            val firstName:String,
                            val lastName:String,
                            val email:String)