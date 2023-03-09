package com.luffy.kotlin.kt02;

/**
 * @author sunzhangfei
 * @since 2021/12/29 4:51 下午
 */
public class HelloJava {
    public static void main(String[] args) {
        User user = new User(1, null, 13);
        user.component1();
        System.out.println(user);
    }

    public void test() {
        new HelloKotlin().hello();
        HelloKotlin.Companion.hello();
        Singleton.INSTANCE.great();
        CallBack callBack = new CallBack() {
            @Override
            public int onBack() {
                return 0;
            }
        };
        Result result = Result.Success.INSTANCE;
        String topStr = HelloKotlinKt.getValTopStr();
        String constValTopStr = HelloKotlinKt.constValTopStr;
        System.out.println("HelloKotlinKt.getTopStr(): " + topStr);
    }
}