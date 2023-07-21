package com.pdev.atoz.order.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderItems {

    private final List<OrderedItem> itemList = new ArrayList<>();

    private int totalPrice;

    public void addItem(List<OrderedItem> items) {
        for (OrderedItem item : items) {
            itemList.add(item);
            totalPrice += item.getTotalPrice();
        }
    }
}
