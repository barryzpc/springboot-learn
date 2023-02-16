package com.zhengpc.myspringboot.stringutils;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhengpengcheng
 */
public class StringUtilsTest {

    @Test
    void test1() {
        String a = "aaaaa";
        Optional.ofNullable(a).ifPresent(u -> {
            System.out.println(u);
        });
    }

    @Test
    void testFlatMap () {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().flatMap((e) -> filterCharacter(e)).forEach(System.out::println);

        //如果使用map则需要这样写
        list.stream().map((e) -> filterCharacter(e)).forEach((e) -> {
            e.forEach(System.out::println);
        });

        //打印aaabbbcccddd
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
    void trap() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = 0, left = 0, right = height.length - 1, preMax = 0, sufMax = 0;
        while (left <= right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            ans += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
        }
        System.out.println(ans);
    }
}
