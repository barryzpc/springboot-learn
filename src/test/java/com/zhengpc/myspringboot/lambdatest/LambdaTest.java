package com.zhengpc.myspringboot.lambdatest;

import com.zhengpc.myspringboot.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {
    @Test
    public void test0(){
        Runnable r = new Runnable(){
            @Override
            public void run(){
                System.out.println("Hello Lambda");
            }
        };
        r.run();
    }

    @Test
    public void test1(){
        Runnable r = () -> System.out.println("Hello Lambda1");
        new Thread(r).start();
    }

    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> stream = list.stream().filter((e) -> {
            System.out.println("Stream API 中间操作");
            return e > 3;
        });

    }

    @Test
    public void testFlatMap () {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().flatMap((e) -> filterCharacter(e)).forEach(System.out::println);

        //如果使用map则需要这样写
        list.stream().map((e) -> filterCharacter(e)).forEach((e) -> {
            e.forEach(System.out::println);
        });
    }

    /**
     * 将一个字符串转换为流
     */
    public Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void testAllMatch(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        boolean allMatch = list.stream().allMatch((e) -> e.equals("aaa"));
        System.out.println(allMatch);

        boolean anyMatch = list.stream().anyMatch((e) -> e.equals("aaa"));
        System.out.println(anyMatch);

    }

    @Test
    public void testReduce(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //Integer sum = list.stream().reduce(0, (x, y) -> x + y);
       // System.out.println(sum);

        for (int i = 0; i < 10; i++) {
            Stream.of(10, 2, 30,4).parallel().findAny().ifPresent(s -> System.out.println(s));
        }

    }

    @Test
    public void testGroupingBy(){
        Map<Employee.Status, List<Employee>> map = employees.stream() .collect(Collectors.groupingBy(Employee::getStauts));
        System.out.println(map);
        Long a = 2222L;
        System.out.println(a.intValue());

    }


    protected List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.SLEEPING),
            new Employee("李四", 38, 5555.55, Employee.Status.WORKING),
            new Employee("王五", 60, 6666.66, Employee.Status.WORKING),
            new Employee("赵六", 8, 7777.77, Employee.Status.SLEEPING),
            new Employee("田七", 58, 3333.33, Employee.Status.VOCATION)
    );


}
