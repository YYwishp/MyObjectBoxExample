package com.gyx.objectboxexample

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Created by gyx on 2019-05-26.
 * ==============================
 * 功能描述：
 *
 *
 */
@Entity
class Address {
    @Id
    var id: Long = 0
    var street: String? = null
    var zip: String? = null
}