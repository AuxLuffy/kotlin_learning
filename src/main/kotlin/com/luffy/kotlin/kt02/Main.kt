package com.luffy.kotlin.kt02

/**
 *
 * @author  sunzhangfei
 * @since 2022/1/4 5:31 下午
 */
fun main() {
//    println("hello world")
    runBlock {
        val list = List(1) {
            println("hello $it")
//            it
        }
        println(list)
        val u1 = User(132, "sunzf", 13)
    }

    testBaseType()

    val stringLenFun: (String) -> Int = { input ->
        input.length
    }
    stringLenFun("abc").let {
        println(it)
        var a = it + 3
    }
    "abc".apply { plus(123).apply { println(this) } }

    println(stringLenFun("abc"))
    println("abc".abc { this.uppercase() })
}


fun runBlock(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println(System.currentTimeMillis() - start)

    val a: String = "aabb"
    val replace = a.replace("\\(b\\)", "\\1")
    println(replace)
}


fun textValVar() {
    val intValue = 1023234234
    val doubleValue = 100.0
    val longValue = 100L
    val l: Long = 3
    val a = 0b001110001
    val b = 0xafcd5607

    val intValue2: Int//如果只读变量在声明时没有初始化值，则必须指明变量类型且在使用前必须初始化，否则在编译时就会报错
    if (intValue - longValue > 0) {
        intValue2 = 3
        println(intValue2)
    }
//    intValue2 = 4
//    println(intValue2)//error, Variable 'intValue2' must be initialized

    var longValue2: Long = intValue.toLong()
}

/**
 * 基础数据类型
 */
fun testBaseType() {
    val intValue1: Int = -129
    val intValue2: Int? = intValue1//反编译后的代码是： Integer intValue2 = Integer.valueOf(intValue1)
    val intValue3: Int? = intValue1//反编译后的代码是： Integer intValue3 = Integer.valueOf(intValue1)
    //==判断值是否相等，因此结果是true
    println(intValue2 == intValue3)
    //===判断地址是否相同，因此结果是false或true，因为Integer.valueOf(int)内部有-128-127的缓存，在此区间的数字返回的是同一个对象，不在此区间返回的是不同的对象
    println(intValue3 === intValue2)
}

public fun String.abc(block: String.() -> String):String {
    return block()
}