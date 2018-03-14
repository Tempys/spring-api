package com.dubovskyi.client.event.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Personne {

    private String nom;
    private String surnom;
    private int age;
}
