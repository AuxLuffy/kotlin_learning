package com.luffy.kotlin.kt02

/**
 * data class独自有的特性：
 * 1. 必须要有带参数的构造方法
 * 2. 不能被继承
 * 3. 提供了toString(), hashCode(), equals(), copy(), componentN()（元素快速访问功能）方法
 * 所以，data class相当于kotlin中的语法糖，其功能用class都能实现，提供了具有数据model的功能，为了提升开发效率，其实它能实现的功能class都能实现
 * 如果想让其字段不参与上述方法的运算就把字段不放在构造里就行了
 *
 * @author  sunzhangfei
 * @since 2021/12/29 4:37 下午
 */
data class User(val id: Int, val name: String?, var age: Int) {}

class User2(val sex: Sex, open var salary: Int) {

}

enum class Sex {
    FEMALE, MALE
}
