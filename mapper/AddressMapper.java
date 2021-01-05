package com.example.demo.mapper;

import com.example.demo.dto.AddressDto;
import com.example.demo.model.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface AddressMapper {

    AddressDto AddressToAddressDto(Address address);

    @InheritInverseConfiguration
    Address fromDto(AddressDto addressDto);
}
