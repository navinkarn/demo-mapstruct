package com.example.demo.model;

public class OrderItem {

    private String name;
    private Long quantity;

    public OrderItem() {
    }

    public OrderItem(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
