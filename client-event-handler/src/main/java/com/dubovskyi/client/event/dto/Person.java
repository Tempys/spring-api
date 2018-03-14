package com.dubovskyi.client.event.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String nickname;
    private int age;
    
}
