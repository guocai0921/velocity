package com.guocai.jdk8.stream;

import com.guocai.mp.mybatis.entity.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * java类简单作用描述
 *
 * @ClassName: StreamTest
 * @Package: com.guocai.jdk8.stream
 * @Description: Stream流测试
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-10-31-8:20
 */
public class CreateStreamTest {


    // 1.通过数组创建流
    @Test
    public void createStreamByArray() {

        // 1.通过Arrays.stream

        // 1.1基本类型
        int[] arr = new int[]{1, 3, 5, 6, 8, 0, 3, 6};
        IntStream stream = Arrays.stream(arr);
        stream.forEach((a) -> System.out.println("a = " + a));
        // 1.2引用类型
        User[] users = new User[]{new User("孙国财", "帅哥", "男神", "SUN", "sun"),
                new User("尹丽珠", "美女", "女神", "YIN", "yin")};
        Stream<User> stream1 = Arrays.stream(users);
        // stream1.forEach(System.out::println);
        stream1.forEach((a) -> {
            System.out.println("a.getName() = " + a.getName());
        });

        // 2.通过Stream.of
        Stream<Integer> stream2 = Stream.of(3, 2, 5, 7, 4, 9, 1, 8);
        // stream2.sorted((a,b)-> a.compareTo(b)).forEach(System.out::println);   // 升序
        stream2.sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);   // 降序

        // 生成的是int[]的流
        Stream<int[]> arr1 = Stream.of(arr);
        arr1.distinct().forEach(System.out::println);
    }

    // 2.通过集合创建流
    @Test
    public void createStreamByCollection() {
        List<String> list = Arrays.asList("1", "0", "9", "4");
        // 创建普通流
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        // 创建并行流
        Stream<String> stringStream = list.parallelStream();
        stringStream.forEach(System.out::println);
    }

    // 3.创建空流
    @Test
    public void createEmptyStream() {
        //创建一个空的stream
        Stream<Integer> stream = Stream.empty();
    }

    // 4.创建无限流
    @Test
    public void createUnLimitStream() {
        //创建无限流，通过limit提取指定大小
        Stream.generate(() -> "number=>" + new Random().nextInt(100)).limit(100).forEach(System.out::println);
        Stream.generate(() -> new User("尹丽珠", "美女", "女神", "YIN", "yin")).limit(20).forEach(System.out::println);
    }

    // 5.创建规律的无限流
    @Test
    public void createUnLimitStream1() {
        Stream.iterate(0,x->x+1).limit(10).forEach(System.out::println);
        Stream.iterate(10,x->x-1).limit(10).forEach(System.out::println);
        Stream.iterate(10, UnaryOperator.identity()).limit(10).forEach(System.out::println);
    }

}
