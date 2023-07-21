package com.pdev.atoz.order.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Embeddable
@Getter
@NoArgsConstructor
public class Email {

    private static final String EMAIL_PATTERN = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    private static final String INVALID_MAIL_ADDRESS_MESSAGE = "올바르지 않은 이메일 형식입니다.";

    @Column(name = "email", unique = true)
    private String mailAddress;

    public Email(String mailAddress) {
        validateMailAddress(mailAddress);
        this.mailAddress = mailAddress;
    }

    private void validateMailAddress(String mailAddress) {
        boolean result = Pattern.matches(EMAIL_PATTERN, mailAddress);
        if (!result) throw new IllegalArgumentException(INVALID_MAIL_ADDRESS_MESSAGE);
    }
}
