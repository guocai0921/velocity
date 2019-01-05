package com.guocai.jdk8.stream;

import com.guocai.mp.mybatis.entity.Person;
import com.guocai.mp.mybatis.entity.Student;
import com.guocai.mp.mybatis.util.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * java类简单作用描述
 *
 * @ClassName: StreamTest
 * @Package: com.guocai.jdk8.stream
 * @Description: Stream综合练习
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-10-31-19:24
 */
public class StreamTest {

    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        // Arrays.stream(arr).reduce((x,y)->x*y).ifPresent(System.out::println);

        // Arrays.stream(arr).map((x) -> x * 2).forEach(System.out::println);

        Student[] students = new Student[]{
                new Student("张三", 26,new Random().nextInt(100)%(100-90+1) + 90),
                new Student("李四", 24,new Random().nextInt(100)%(100-90+1) + 90),
                new Student("王五", 23,new Random().nextInt(100)%(100-90+1) + 90),
                new Student("赵六", 29,new Random().nextInt(100)%(100-90+1) + 90),
                new Student("钱七", 30,new Random().nextInt(100)%(100-90+1) + 90),
                new Student("孙八", 22,new Random().nextInt(100)%(100-90+1) + 90),
                new Student("周九", 27,new Random().nextInt(100)%(100-90+1) + 90),
                new Student("吴十", 25,new Random().nextInt(100)%(100-90+1) + 90),
                new Student("郑一", 26,new Random().nextInt(100)%(100-90+1) + 90),
                new Student("姜二", 28,new Random().nextInt(100)%(100-90+1) + 90),
        };

        // 升序
        Arrays.stream(students).sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
        // 降序
        // Arrays.stream(students).sorted(Comparator.comparing(Student::getAge).reversed()).forEach(System.out::println);
        // 求年龄最大值
        // Arrays.stream(students).max((a,b)->a.getAge().compareTo(b.getAge())).ifPresent(System.out::println);
        // 求年龄的最小值
        // Arrays.stream(students).min(Comparator.comparing(Student::getAge)).ifPresent(System.out::println);
        // Stream.of(students).min(Comparator.comparing(Student::getAge)).ifPresent(System.out::println);
        //
        // List<Person> list = new ArrayList<>();
        // list.add(new Person("A","JQ20181031001"));
        // list.add(new Person("A","JQ20181031002"));
        // list.add(new Person("A","JQ20181031006"));
        // System.out.println("JQ20181019003".substring(2,10));
        // list.stream().max(Comparator.comparing(Person::getNumber)).ifPresent(System.out::println);
        // Person person = list.stream().filter((a) -> a.getNumber().substring(2, 10).equals(DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_yyyyMMdd))).
        //         max(Comparator.comparing(Person::getNumber)).get();
        // list.stream().filter((a) -> a.getNumber().substring(2, 10).equals(DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_yyyyMMdd))).
        //         max(Comparator.comparing(Person::getNumber)).ifPresent(System.out::println);
    }


    @Before
    public void before() {

    }

}
