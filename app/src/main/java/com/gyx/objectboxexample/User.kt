package com.gyx.objectboxexample

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

/**
 * Created by gyx on 2019-05-26.
 * ==============================
 * 功能描述：
 *
 *
 */
@Entity
class User {
    @Id
    var id: Long = 0
    var name: String? = null
    var age: Int = 0
    var height: Int = 0
    var weight: Int = 0
    var addresses: Int = 0
}