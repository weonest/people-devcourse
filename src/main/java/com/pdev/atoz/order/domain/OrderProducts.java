package com.pdev.atoz.order.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderProducts {

    private final List<OrderedProduct> itemList = new ArrayList<>();

    private int totalPrice;

    public void addItem(List<OrderedProduct> items) {
        for (OrderedProduct item : items) {
            itemList.add(item);
            totalPrice += item.getTotalPrice();
        }
    }
}
