package com.pdev.atoz.order.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderItems {

    private final List<OrderItem> orderItemList = new ArrayList<>();

    public void addItem(List<OrderItem> items) {
        for (OrderItem item : items) {
            orderItemList.add(item);
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem item : orderItemList) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}
