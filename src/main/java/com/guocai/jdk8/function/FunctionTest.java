package com.guocai.jdk8.function;

import org.junit.Test;

import java.util.function.Function;

/**
 * java类简单作用描述
 *
 * @ClassName: FunctionTest
 * @Package: com.guocai.jdk8.function
 * @Description: 函数式接口
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-10-31-8:51
 */
public class FunctionTest {

    @Test
    public void test() {
        Function<String,String> function = (a) -> a.toLowerCase();
        String helloWorld = function.apply("HelloWorld");
        System.out.println("helloWorld = " + helloWorld);

    }

}
