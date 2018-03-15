package com.dubovskyi.client.event.dto;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.metadata.Type;

import javax.xml.transform.Source;

public class UserConvecter extends CustomConverter<User,Boolean> {
    @Override
    public Boolean convert(User source, Type<? extends Boolean> destinationType, MappingContext mappingContext) {
        return source == User.ADMIN;
    }
}
