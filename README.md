# kotlin_learning

## 一、Hello World

先来写一个HelloWorld的示例代码
```kotlin
package main
fun main() {
    val msg: String = "Hello World!"
    println(msg)
}
```

从上面可以看出kotlin和java的不同之处:
1. 函数可以定义在文件的最外层，不需要把它放在类中
2. 用关键字fun来声明一个函数
3. 可以省略main方法的参数
4. 参数类型写在变量名后，有助于在类型自动化推导时省略类型声明
5. 使用println代替了System.out.println，这是kotlin标准库提供的对java标准库函数的简易封装
6. 可以省略代码结尾的分号

## 二、package

kotlin中以`package`开头，同一个文件中定义的所有声明（类，函数，属性等）都会被放到这个包中。同个包中的声明可以直接使用，不同包的声明需要导入后使用

包的声明需要放在文件顶部，import语句紧跟其后

```kotlin
package base
import java.text.SimpleDateFormat
import java.util.*
```

kotlin中不区分导入的是类还是函数，可以使用import关键字导入任何类型的声明，也可以在包名后加上`.*`来导入包中定义的所有声明，从而让包中定义的类、顶层函数和属性都可以直接使用

java语言中规定类必须要放到和包结构匹配的文件夹目录结构中，且文件名必须和类名相同。而kotlin允许把多个类放到同一个文件中，文件名也可以任意选择。此外，kotlin也没有对文件目录结构做任何限制，包层级结构不必遵守同java的层级规范，但kotlin官方还是建议根据目录结构放置相关代码，以便可以更清楚的管理程序源文件。

在kotlin中可以使用`as`关键字来给声明加别名，eg：
```kotlin
import java.math.BigDecimal
import com.luffy.BigDecimal as MyBigDecimal

fun main() {
    val a: BigDecimal = BigDecimal(0)
    val b: MyBigDecimal = MyBigDecimal(2)
    println(a.javaClass) //java.math.BigDecimal
    println(b.javaClass) //com.luffy.BigDecimal
}
```
可以看出，类型别名通常用来解决同一个文件中两个相同类引用导致的类冲突，类型别名不会引入新的类弄，依然对应其底层的类型 

## 三、变量与数据类型

java中默认变量是可变的，如果想要声明成不可变量必须显式加上final关键字。kotlin中变量声明有两个关键字：一个是var，可变量；一个是val，不可变量，只读，同java中的final。

如果只读变量在声明时没有初始化值，则必须指明变量类型，且在使用前必须初始化，否则在编译时就会报错。eg:
```kotlin
fun textValVar() {
    val intValue = 1023234234
    val doubleValue = 100.0
    val longValue = 100L

    val intValue2: Int//如果只读变量在声明时没有初始化值，则必须指明变量类型且在使用前必须初始化，否则在编译时就会报错
    if (intValue - longValue > 0) {
        intValue2 = 3
        println(intValue2)
    }
//    intValue2 = 4
//    println(intValue2)//error, Variable 'intValue2' must be initialized
}
```

### 1、基本数据类型
在kotlin中一切皆对象，虽然kotlin对`byte、char、integer、float或者boolean`仍有保留，但全部作为对象存在的，只是运算时还是原生类型值。
* 数字、字符和布尔值可以在运行时表示为原生类型值，但对开发者来说，它们看起来就是普通的类。
* 对于数字没有隐式拓宽转换，而在java中int可以隐式转换为long
* 如果声明变量时未显式指明类型，则kotlin会自动推断，推断原则是按取值范围来自动推断的
* 字符不能视为数字
* 不支持八进制

kotlin中可空类型不能用Java的基本类型表示，因为null只能存储在java的引用类型的变量中，这意味着只要使用了可空类型类型，它就会被编译成对应的包装类型
```kotlin
/**
 * 基础数据类型
 */
fun testBaseType() {
    val intValue1: Int = 1200
    val intValue2: Int? = intValue1//反编译后的代码是： Integer intValue2 = Integer.valueOf(intValue1)
    val intValue3: Int? = intValue1//反编译后的代码是： Integer intValue3 = Integer.valueOf(intValue1)
    //==判断值是否相等，因此结果是true
    println(intValue2 == intValue3)
    //===判断地址是否相同，因此结果是false
    println(intValue3 === intValue2)
}
```
#### `const val`和`val`的区别
* `const`必须修饰val
* `const`只允许在top-level级别和object中声明，使用方法如下：
  ```kotlin
  const val THOUSAND = 1000
  val valVariable = 15
  object MyObject {//object在top level中使用表增此类为单例
    const val constNameObj: String = "consNameObj"
  } 
  
  class MyClass {
    companion object Factory {
      const val constNamCompanionObj: String = "constNamCompanionObj"
    }
  }
  ```
* 通过idea的`Tools -> Kotlin -> Show Kotlin ByteCode`可以看出`val`和`const val`的区别是：
  * `const val`可见性为`public final static`, 可以直接访问。
  * `val`的可见性为`private final static`, 但会生成相应的`get`方法
* 总结，当定义常量时，出于效率考虑，我们应该用`const val`方式，避免频繁函数调用。

