package com.pdev.atoz.order.domain;

import lombok.Getter;

@Getter
public class Email {

    private String mailAddress;

    public Email(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
