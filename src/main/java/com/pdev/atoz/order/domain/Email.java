package com.pdev.atoz.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Email {

    @Column(name = "email", nullable = false)
    private String mailAddress;

    public Email(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
