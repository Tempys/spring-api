package com.dubovskyi.client.event.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Personne {

    private String nom;
    private String surnom;
    private int age;
    private Map<String, String> subs;
    private List<String> heading;
    private User user;
    private DetailsDto details;
}
