package com.example.demo.mapper;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import org.mapstruct.*;



@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, uses ={ AddressMapper.class, OrderItemMapper.class, ContactTypeMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR )
/*
1. unmappedTargetPolicy=ReportingPolicy.ERROR, if we have missed a property to map, we will get a compile time error message.
2. componentModel=spring, injectionStrategy = InjectionStrategy.CONSTRUCTOR is used to inject AddressMapper & OrderItemMapper into CustomerMapper.
For now I am using Constructor injection. We can use other dependency injections as well.
*/

public abstract class CustomerMapper { //When we compile the project, the implementation class is auto generated. In our case CustomerMapperImpl.java

    //invoke validate method before mapping
    @BeforeMapping
    public void beforeMappingMethod(){
        System.out.println("beforeMappingMethod gets invoked before mapping");
    }
    @Mappings({
            //an example of mapping if the field name is different. For example, customerId to id and customerTitle to title, orderItems to orderItemDtos
            @Mapping(source = "id", target = "customerId"),
            @Mapping(source = "title", target = "customerTitle", defaultValue = "unknown title"),//default value will be used if source value is null
            @Mapping(source = "orderItems", target = "orderItemDtos"),
            @Mapping(source="contactType", target = "contactTypeDto")
    })

    public abstract CustomerDto customerToDto(Customer customer);

    //instead of writing a new mapping rule, we can use Inverse configuration. This will be inverse (opposite) of customerToDto
    @InheritInverseConfiguration(name = "customerToDto" )
    public abstract Customer customerFromDto(CustomerDto customerDto);

    //invoke after mapping is done
    @AfterMapping
    public void afterMappingMethod(){
        System.out.println("afterMappingMethod gets invoked after all mapping");
    }
}
