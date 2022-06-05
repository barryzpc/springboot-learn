package com.zhengpc.myspringboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpengcheng
 */
@Component
@PropertySource(value = "classpath:user.properties", encoding = "UTF-8")
@ConfigurationProperties(prefix = "user")
public class User {
    private String userName;
    private String passWord;
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
    public User() {
    }
    public User(String userName, String passWord, Integer age, Boolean boss, Date birth, Map<String, Object> maps, List<Object> lists, Dog dog) {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.boss = boss;
        this.birth = birth;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Boolean getBoss() {
        return boss;
    }
    public void setBoss(Boolean boss) {
        this.boss = boss;
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public Map<String, Object> getMaps() {
        return maps;
    }
    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }
    public List<Object> getLists() {
        return lists;
    }
    public void setLists(List<Object> lists) {
        this.lists = lists;
    }
    public Dog getDog() {
        return dog;
    }
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
