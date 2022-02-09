package com.luffy.kotlin.kt02

/**
 *
 * @author  sunzhangfei
 * @since 2022/1/4 5:31 下午
 */
fun main() {
    println("hello world")
    runBlock {
        List(1) {
            println("hello $it")
        }
    }

}

fun runBlock(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() - start)

    val a: String = "aabb"
    val replace = a.replace("\\(b\\)", "\\1")
    println(replace)
}