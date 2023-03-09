package com.luffy.kotlin.kt02


/**
 *
 * @author  sunzhangfei
 * @since 2021/12/29 4:52 下午
 */
val valTopStr: String = "top"
const val constValTopStr = "topConst"
fun main(args: Array<String>) {
    println(args.contentToString())
    val user = User(1, "null", 13)
    println(user)
    val map = HelloKotlin::class.constructors.map(::println)
    HelloJava::class.constructors.map { println(it) }
    HelloKotlin.hello();

    val callback = object : CallBack {
        override fun onBack(): Int {
            HelloKotlin.hello()
            return 0
        }
    }
    testSubMethod()

}

class HelloKotlin {
    fun hello() {
        HelloJava().test();
    }
    val des = 212
    companion object {
        val companionVal = 123;
        const val companionObjectConst: Int = 132;
        fun hello() {
            Singleton.great()
            Singleton.name
        }
    }
}

/**
 * 密封类
 * 1. 表示受限的类继承结构：当一个值为有限的几种类型，而不能有任何其他类型时
 * 2. 由于编译器知道一共有几种类型，可用来优化when对分支的判断，可以不用再写else分支
 * 3. 反编译sealed类后可以看到此类是抽象类且构造是private的，其内部的类型是几个单例子类
 *
 * 与枚举类的区别：
 * 1. 枚举类只能有一个实例，但密封类可以有多个实例，密封类更在意类型，枚举更在意数据。
 * 2. 密封类子类可以有自己单独的方法，而枚举不可以，相对于枚举更灵活
 */
sealed class Result {
    object Success : Result() {
        fun getSuccessResp(): String {
            return "success"
        }

        override fun getCode(): Int {
            return 200
        }
    }

    object Failure : Result() {
        fun getFailResp(): String {
            return "fail"
        }

        override fun getCode(): Int {
            return 404
        }
    }

    abstract fun getCode(): Int
}

object Singleton {
    const val name: String = "Singleton"
    val normalString: String = "normal"
    fun great() {
        val s = Result.Success
        val result = if (true) Result.Success else Result.Failure
        println("hello $name")
    }

    fun testWhen(result: Result) {
        when (result) {
            is Result.Success -> TODO()
            is Result.Failure -> TODO()
        }
        val b = result is Result.Failure
    }
}

enum class WeekDay(cname: String) {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    init {
        println(name)
    }

    fun getChinese() {

    }
}