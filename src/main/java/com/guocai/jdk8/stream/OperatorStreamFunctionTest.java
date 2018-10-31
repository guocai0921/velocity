package com.guocai.jdk8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * java类简单作用描述
 *
 * @ClassName: OperatorStreamFunctionTest
 * @Package: com.guocai.jdk8.stream
 * @Description: 对stream的操作常用的方法
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-10-31-10:01
 */
public class OperatorStreamFunctionTest {

    // 1.map：转换流，将一种类型的流转换为另外一种流
    @Test
    public void testMap() {
        /**
         * map把一种类型的流转换为另外一种类型的流
         * 将String数组中字母转换为小写
         */
        String[] arr = new String[]{"yes", "YES", "no", "NO"};
        Arrays.stream(arr).map((a) -> a.toLowerCase()).forEach(System.out::println);
    }

    // 2.filter：过滤流，过滤流中的元素
    @Test
    public void testFilter() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(arr).filter((a) -> a > 3 && a < 8).forEach(System.out::println);
    }

    // 3.flapMap：拆解流，将流中每一个元素拆解成一个流
    @Test
    public void testFlapMap1() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        // Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
        Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::println);
    }

    String[] arr1 = {"abc", "a", "bc", "abcd"};

    // 4.sorted：对流进行排序

    /*
     * 升序
     */
    @Test
    public void testSorted1_() {
        /**
         * 按照字符长度排序
         */
        Arrays.stream(arr1).sorted((x, y) -> {
            if (x.length() > y.length())
                return 1;
            else if (x.length() < y.length())
                return -1;
            else
                return 0;
        }).forEach(System.out::println);
        Arrays.stream(arr1).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

    /**
     * 倒序
     * reversed(),java8泛型推导的问题，所以如果comparing里面是非方法引用的lambda表达式就没办法直接使用reversed()
     * Comparator.reverseOrder():也是用于翻转顺序，用于比较对象（Stream里面的类型必须是可比较的）
     * Comparator. naturalOrder()：返回一个自然排序比较器，用于比较对象（Stream里面的类型必须是可比较的）
     */
    @Test
    public void testSorted2_() {
        Arrays.stream(arr1).sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
        Arrays.stream(arr1).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        Arrays.stream(arr1).sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    /**
     * thenComparing
     * 先按照首字母排序
     * 之后按照String的长度排序
     */
    @Test
    public void testSorted3_() {
        Arrays.stream(arr1).sorted(Comparator.comparing(this::com1).thenComparing(String::length)).forEach(System.out::println);
    }

    public char com1(String x) {
        return x.charAt(0);
    }


    String[] arr2 = new String[]{"a", "b", "c", "d"};
    String[] arr3 = new String[]{"d", "e", "f", "g"};
    String[] arr4 = new String[]{"i", "j", "k", "l"};

    // 5.limit，限制从流中获得前n个数据
    @Test
    public void testLimit() {
        Stream.iterate(1, x -> x + 1).limit(20).forEach(System.out::println);
    }

    // 6.skip，跳过前n个数据
    @Test
    public void testSkip() {
        Stream.of(arr2).skip(2).limit(2).forEach(System.out::println);
        Stream.iterate(1, x -> x + 1).skip(5).limit(50).forEach(System.out::println);
    }

    // 7.concat,可以把两个stream合并成一个stream（合并的stream类型必须相同）,只能两两合并
    @Test
    public void testConcat() {
        Stream<String> stream1 = Stream.of(arr3);
        Stream<String> stream2 = Stream.of(arr4);
        Stream.concat(stream1, stream2).distinct().forEach(System.out::println);
    }

    String[] arr5 = new String[]{"b", "ab", "abc", "abcd", "abcde"};

    // 8.max、min ,最大最小值
    @Test
    public void testMaxAndMin() {
        Stream.of(arr5).max(Comparator.comparing(String::length)).ifPresent(System.out::println);
        Stream.of(arr5).min(Comparator.comparing(String::length)).ifPresent(System.out::println);
    }

    // 9.count,计算数量
    @Test
    public void testCount() {
        long count = Stream.of(arr5).count();
        System.out.println("count = " + count);

    }

    // 10.findFirst,查找第一个
    @Test
    public void testFindFirst() {
        String str = Stream.of(arr5).parallel().filter(x -> x.length() > 3).findFirst().orElse("noghing");
        System.out.println(str);
    }

    // 11.findAny，找到所有匹配的元素，对并行流十分有效，只要在任何片段发现了第一个匹配元素就会结束整个运算
    @Test
    public void testFindAny(){
        Optional<String> optional = Stream.of(arr5).parallel().filter(x->x.length()>3).findAny();
        optional.ifPresent(System.out::println);
    }


    // 12.anyMatch ，是否含有匹配元素
    @Test
    public void testAnyMatch(){
        Boolean aBoolean = Stream.of(arr5).anyMatch(x->x.startsWith("a"));
        System.out.println(aBoolean);
    }

    // 13.reduce,接收两个参数，reduce把结果继续和序列的下一个元素做累积计算
    @Test
    public void testStream1() {
        Optional<Integer> optional = Stream.of(1,2,3).filter(x->x>1).reduce((x,y)->x+y);
        System.out.println(optional.get());
    }

}
