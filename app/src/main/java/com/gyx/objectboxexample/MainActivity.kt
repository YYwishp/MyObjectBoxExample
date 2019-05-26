package com.gyx.objectboxexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.objectbox.Box
import io.objectbox.android.AndroidScheduler
import io.objectbox.kotlin.boxFor
import io.objectbox.kotlin.query
import io.objectbox.relation.ToMany
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var boxFor:Box<User>
    lateinit var boxAddress:Box<Address>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        boxFor = MyApplication.mBoxStore.boxFor()
        boxAddress = MyApplication.mBoxStore.boxFor()

//         boxFor = ObjectBox.boxStore.boxFor<User>()


    }


    fun addData(view: View) {


        thread {
            for (n in 1..10000) {
                var address = Address()
                address.street = "address-$n"
                address.zip = "zip-$n"
                boxAddress.put(address)
            }

            for (n in 1..100000) {
                var user = User()
                user.age = n
                user.height = 100 + n
                user.name = "user-$n"
                user.weight = 110 + n
                user.addresses = n
                boxFor.put(user)

            }
        }







    }

    fun queryData(view: View) {
//        var query = boxFor.query {
//            this.equal(User_.age, 100)
//        }


        var builder = boxFor.query()

        var find = builder.filter {


            it.age == 1000
        }.build().find()




        println(find.size)


    }

    fun queryInRx(view: View) {
        var builder = boxFor.query()

        var query = builder.filter {


            it.age == 1000
        }.build()


        query.subscribe().on(AndroidScheduler.mainThread())
            .single().onlyChanges().observer {

            }
    }
}




















