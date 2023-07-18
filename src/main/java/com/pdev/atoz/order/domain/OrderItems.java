package com.pdev.atoz.order.domain;

import com.pdev.atoz.order.dto.OrderItemCreateDto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderItems {

    private final List<OrderItemCreateDto> orderItemCreateDtoList = new ArrayList<>();

    private int totalPrice;

    public void addItem(List<OrderItemCreateDto> items) {
        for (OrderItemCreateDto item : items) {
            orderItemCreateDtoList.add(item);
            totalPrice += item.getTotalPrice();
        }
    }
}
