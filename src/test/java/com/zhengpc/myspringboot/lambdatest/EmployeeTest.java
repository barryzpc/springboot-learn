package com.zhengpc.myspringboot.lambdatest;

import com.zhengpc.myspringboot.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class EmployeeTest {

    protected List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.SLEEPING),
            new Employee("李四", 38, 5555.55, Employee.Status.WORKING),
            new Employee("王五", 60, 6666.66, Employee.Status.WORKING),
            new Employee("赵六", 8, 7777.77, Employee.Status.SLEEPING),
            new Employee("田七", 58, 3333.33, Employee.Status.VOCATION)
    );

    @Test
    public void test1(){
        employees.stream().filter((e) -> e.getSalary() >= 5000).forEach(System.out::println);
    }

    @Test
    public void test2(){
        employees.stream().filter((employee) -> employee.getAge() >= 30).forEach(System.out::println);
    }

    @Test
    public void test3(){
        employees.stream().filter((e) -> e.getSalary() >= 5000).limit(2).forEach(System.out::println);
    }

    @Test
    public void test4(){
        employees.stream().filter((e) -> e.getSalary() >= 5000).map(Employee::getName).forEach(System.out::println);
    }

    @Test
    public void test5(){
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        System.out.println(list);
        System.out.println(list.size());

        String[] arr1 = {"1", "2", "3"};
        List<String> strings = Arrays.asList(arr1);
        strings.remove("2");

        System.out.println(strings.toString());

    }
}