package com.dubovskyi.client.event.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
//@AllArgsConstructor
public class Person {
    private String name;
    private String nickname;
    private int age;
    private Map<String, String> subs;
    List<String> heading;
    private Boolean isAdmin;
    private boolean isAnonim;
    private Details details;
    
}
