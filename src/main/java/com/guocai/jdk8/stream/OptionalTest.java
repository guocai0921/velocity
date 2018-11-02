package com.guocai.jdk8.stream;

import com.guocai.mp.mybatis.entity.Person;
import com.guocai.mp.mybatis.entity.Student;
import com.guocai.mp.mybatis.util.PointUtil;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * java类简单作用描述
 *
 * @ClassName: OptionalTest
 * @Package: com.guocai.jdk8.stream
 * @Description: Optional类型之学习
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-10-31-19:25
 */
public class OptionalTest {
    // 通常聚合操作会返回一个Optional类型，Optional表示一个安全的指定结果类型，
    // 所谓的安全指的是避免直接调用返回类型的null值而造成空指针异常，
    // 调用optional.ifPresent()可以判断返回值是否为空，
    // 或者直接调用ifPresent(Consumer<? super T> consumer)在结果部位空时进行消费操作；
    // 调用optional.get()获取返回值。

    @Test
    public void test() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("A","JQ20181031001"));
        list.add(new Person("B","JQ20181031002"));
        list.add(new Person("F","JQ20181031006"));
        List<String> list2 = new ArrayList<String>() {
            {
                add("user1");
                add("user2");
            }
        };
        Optional<String> opt = Optional.of("andy with u");
        opt.ifPresent(list2::add);
        list2.forEach(System.out::println);
    }


    @Test
    public void test2() {
        Integer[] arr = new Integer[]{4,3,6,2,8,1,7,9,5,0};
        // Integer integer = Stream.of(arr).filter((x) -> x > 9).max(Comparator.naturalOrder()).orElse(-1);
        // System.out.println("integer = " + integer);
        Integer result1 = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElseGet(()->-1);
        System.out.println(result1);
        Integer result2 = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElseThrow(RuntimeException::new);
        System.out.println(result2);
    }

    // Optional的创建
    @Test
    public void test3() {
        Optional<Student> studentOptional = Optional.of(new Student("user1",21,new Random().nextInt(100)%(100-90+1) + 90));
        Optional<String> optionalStr = studentOptional.map(Student::getName);
        System.out.println(optionalStr.get());

        List<Person> list = new ArrayList<>();
        list.add(new Person("A","JQ20181031001"));
        list.add(new Person("B","JQ20181031002"));
        list.add(new Person("F","JQ20181031006"));

        Optional<List<Person>> list1 = Optional.of(list);
        list1.map((x)->x.stream().map((y)->y.getNumber().substring(10))).get().forEach(System.out::println);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("a",1);
        map.forEach((x,y)-> System.out.println(x +"<=>"+ y));
    }

    Student[] students;
    @Before
    public void init(){
        students = new Student[100];
        for (int i=0;i<30;i++){
            Student student = new Student("user",i,new Random().nextInt(100)%(100-90+1) + 90);
            students[i] = student;
        }
        for (int i=30;i<60;i++){
            Student student = new Student("user"+i,i,new Random().nextInt(100)%(100-90+1) + 90);
            students[i] = student;
        }
        for (int i=60;i<100;i++){
            Student student = new Student("user"+i,i,new Random().nextInt(100)%(100-90+1) + 90);
            students[i] = student;
        }

    }

    @Test
    public void testCollect1(){
        // 数组转List集合
        List<Student> list = Stream.of(students).collect(Collectors.toList());
        // list.forEach(System.out::println);

        // 数组转Set集合
        Set<Student> set = Stream.of(students).collect(Collectors.toSet());
        // set.forEach(System.out::println);

        // 数组转Map(如果包含相同的key，则需要提供第三个参数，否则报错)
        Map<Integer, String> map = Stream.of(students).collect(Collectors.toMap(Student::getAge, Student::getName, (x, y) -> x + y));
        map.forEach((x,y)-> System.out.println(x+"<=>"+y));
    }

    /**
     * 生成数组
     */
    @Test
    public void testCollect2(){
        // Student[] s = Arrays.stream(students).toArray(Student[]::new);
        // for (int i=0;i<s.length;i++)
        //     System.out.println(s[i]);

        List<Integer> listi = new ArrayList<Integer>();
        listi.add(1);
        listi.add(2);
        listi.add(3);
        Integer[] integers = listi.stream().toArray(Integer[]::new);
        Stream.of(integers).forEach(System.out::println);
    }

    /**
     * 指定生成的类型
     */
    @Test
    public void testCollect3(){
        HashSet<Student> s = Arrays.stream(students).collect(Collectors.toCollection(HashSet::new));
        s.forEach(System.out::println);
    }

    @Test
    public void testCollect4(){
        Arrays.stream(students).forEach(System.out::println);
        IntSummaryStatistics summaryStatistics = Arrays.stream(students).collect(Collectors.summarizingInt(Student::getScore));
        System.out.println("getAverage->"+summaryStatistics.getAverage());
        System.out.println("getMax->"+summaryStatistics.getMax());
        System.out.println("getMin->"+summaryStatistics.getMin());
        System.out.println("getCount->"+summaryStatistics.getCount());
        System.out.println("getSum->"+summaryStatistics.getSum());
    }
    
    @Test
    public void test4 () {
        double d = 10.0;
        double e = 3.0;
        String s = PointUtil.reservedCustomizeDecimalPoints(d,e,6);
        System.out.println("s = " + s);
    }

    @Test
    public void testGroupBy1(){
        Map<String,List<Student>> map = Arrays.stream(students).collect(Collectors.groupingBy(Student::getName));
        map.forEach((x,y)-> System.out.println(x+"->"+y));
    }

    /**
     * 如果只有两类，使用partitioningBy会比groupingBy更有效率
     */
    @Test
    public void testPartitioningBy(){
        Map<Boolean,List<Student>> map = Arrays.stream(students).collect(Collectors.partitioningBy(x->x.getScore()>95));
        map.forEach((x,y)-> System.out.println(x+"->"+y));
    }

    /**
     * downstream指定类型
     */
    @Test
    public void testGroupBy2(){
        Map<String,Set<Student>> map = Arrays.stream(students).collect(Collectors.groupingBy(Student::getName,Collectors.toSet()));
        map.forEach((x,y)-> System.out.println(x+"->"+y));
    }


    /**
     * downstream 聚合操作
     */
    @Test
    public void testGroupBy3(){
        /**
         * counting
         */
        // Map<String,Long> map1 = Arrays.stream(students).collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
        // map1.forEach((x,y)-> System.out.println(x+"->"+y));
        /**
         * summingInt
         */
        // Map<String,Integer> map2 = Arrays.stream(students).collect(Collectors.groupingBy(Student::getName,Collectors.summingInt(Student::getScore)));
        // map2.forEach((x,y)-> System.out.println(x+"->"+y));
        /**
         * maxBy
         */
        // Map<String,Optional<Student>> map3 = Arrays.stream(students).collect(Collectors.groupingBy(Student::getName,Collectors.maxBy(Comparator.comparing(Student::getScore))));
        // map3.forEach((x,y)-> System.out.println(x+"->"+y));
        /**
         * mapping
         */
        // Map<String,Set<Integer>> map4 = Arrays.stream(students).collect(Collectors.groupingBy(Student::getName,Collectors.mapping(Student::getScore,Collectors.toSet())));
        // map4.forEach((x,y)-> System.out.println(x+"->"+y));
    }

    @Test
    public void test5 () {
        int[] arr = new int[]{2,3,4,5,6};
        int[] ints = Arrays.stream(arr).map((x) -> x + 2).toArray();
        Arrays.stream(ints).forEach(System.out::println);
    }

    @Test
    public void test6 () {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三",25,90));
        list.add(new Student("李四",19,90));
        list.add(new Student("王五",20,90));
        list.add(new Student("赵六",18,90));
        list.add(new Student("钱七",15,90));

        // Iterator<Student> iterator = list.stream().iterator();
        // while (iterator.hasNext()){
        //     System.out.println("iterator.next() = " + iterator.next());
        // }

        List<Student> collect = list.stream().filter((x) -> x.getAge() < 20).collect(Collectors.toList());
        collect.forEach(System.out::println);


    }

}
