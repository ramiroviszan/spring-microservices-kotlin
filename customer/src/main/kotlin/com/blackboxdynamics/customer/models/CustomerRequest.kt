package com.blackboxdynamics.customer.models

import com.blackboxdynamics.common.NoArg

@NoArg
data class CustomerRequest(val firstName:String,
                           val lastName:String,
                           val email:String)