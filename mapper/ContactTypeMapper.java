package com.example.demo.mapper;

import com.example.demo.dto.ContactTypeDto;
import com.example.demo.model.ContactType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper
public interface ContactTypeMapper {
/*
We are mapping here the source enum (ContactType) to destination enum (ContactTypeDtoEnum) and
 injecting this into CustomerMapper
*/

    @ValueMappings({
            @ValueMapping(source = "PHONE", target = "PHONE_CONTACT"),
            @ValueMapping(source = "EMAIL", target = "EMAIL_CONTACT"),
            @ValueMapping(source = "OTHER", target = "OTHER_CONTACT")
    })
    ContactTypeDto contactTypeToContactTypeDto(ContactType contactType);

    @InheritInverseConfiguration
    ContactType dtoToContactType(ContactTypeDto contactTypeDto);
}
