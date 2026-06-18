package com.example.rest.demo.usermmdto;

import java.util.List;

import com.example.rest.demo.entities.Order;

public class UsermmDto {

    public UsermmDto() {
    }

    private long sno;
    private String firstName;
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public void setSno(long sno) {
        this.sno = sno;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
