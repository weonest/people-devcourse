package com.pdev.atoz.order.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderItems {

    private final List<OrderItem> orderItemList = new ArrayList<>();

    private int totalPrice;

    public void addItem(List<OrderItem> items) {
        for (OrderItem item : items) {
            orderItemList.add(item);
            totalPrice += item.getTotalPrice();
        }
    }
}
