package com.zhengpc.myspringboot.entity;

import lombok.*;
import java.io.Serializable;


/**
 * @author zhengpengcheng
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private static final long serialVersionUID = -9079722457749166858L;
    private String name;
    private Integer age;
    private Double salary;
    private Status stauts;
    public enum Status {
        WORKING,
        SLEEPING,
        VOCATION
    }

}

