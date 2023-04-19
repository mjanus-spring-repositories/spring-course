package com.mjanus.messaging;

public class Order {
    private int price;
    private String name;
    private String address;

    public Order(int price, String name, String address) {
        this.price = price;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
