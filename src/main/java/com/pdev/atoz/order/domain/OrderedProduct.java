package com.pdev.atoz.order.domain;

import lombok.Builder;
import lombok.Getter;


@Getter
public class OrderedProduct {

    private final long productId;

    private final String category;

    private final int quantity;

    private final int totalPrice;

    @Builder
    private OrderedProduct(long productId,
                           String category,
                           int price,
                           int quantity) {
        this.productId = productId;
        this.category = category;
        this.quantity = quantity;
        this.totalPrice =  price * quantity;
    }
}
