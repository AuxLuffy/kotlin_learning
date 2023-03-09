package com.luffy.kotlin.kt02

import java.util.function.Predicate


/**
 *
 * @author  sunzhangfei
 * @since 2023/3/7 14:11
 */
fun testSubMethod(): Int {
    val list = listOf("a", "b", "c");
    val filter = list.filter { it == "a" }
    println(filter)
    val cond1 = object : Predicate<String> {
        override fun test(t: String): Boolean {
            return t.contains("a")
        }
    }
    val cond = Predicate<String> { it.contains("a") }
    val cal = object : CallBack {
        override fun onBack(): Int {
            return list.size
        }
    }
    cond1.test("d")
    val test = cond.test("abc")
    val result = cal.onBack()
    return cal.onBack()
}