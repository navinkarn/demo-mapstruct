package com.example.demo.mapper;

import com.example.demo.dto.OrderItemDto;
import com.example.demo.model.OrderItem;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")

public interface  OrderItemMapper {

     OrderItem toOrder(OrderItemDto orderItemDto);

    @InheritInverseConfiguration
    OrderItemDto fromOrder(OrderItem orderItem);

}
