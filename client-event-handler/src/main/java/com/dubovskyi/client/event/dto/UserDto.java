package com.dubovskyi.client.event.dto;

public enum  UserDto {
    ANONIM("ANONIM"),
    ADMIN("ADMIN");

    private final String name;

    UserDto(String name) {
        this.name = name;
    }
}
