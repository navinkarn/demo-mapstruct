package com.example.demo.dto;

import com.example.demo.model.ContactType;

import java.util.List;

public class CustomerDto {
    private long customerId;
    private String firstName;
    private String lastName;
    private String customerTitle;
    private AddressDto address;
    private List<OrderItemDto> orderItemDtos;
    private ContactTypeDto contactTypeDto;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerTitle() {
        return customerTitle;
    }

    public void setCustomerTitle(String customerTitle) {
        this.customerTitle = customerTitle;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public List<OrderItemDto> getOrderItemDtos() {
        return orderItemDtos;
    }

    public void setOrderItemDtos(List<OrderItemDto> orderItemDtos) {
        this.orderItemDtos = orderItemDtos;
    }

    public ContactTypeDto getContactTypeDto() {
        return contactTypeDto;
    }

    public void setContactTypeDto(ContactTypeDto contactTypeDto) {
        this.contactTypeDto = contactTypeDto;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerTitle='" + customerTitle + '\'' +
                ", address=" + address +
                ", orderItemDtos=" + orderItemDtos +
                ", contactTypeDto=" + contactTypeDto +
                '}';
    }
}
