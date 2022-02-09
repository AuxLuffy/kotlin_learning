package com.luffy.kotlin.kt02

import java.util.*

/**
 *
 * @author  sunzhangfei
 * @since 2021/12/29 4:52 下午
 */
fun main(args: Array<String>) {
    println(args.contentToString())
    val user = User(1, "null")
    println(user)
    HelloKotlin::class.constructors.map(::println)
    HelloJava::class.constructors.map { println(it) }
}

class HelloKotlin {
    fun hello() {

    }
}