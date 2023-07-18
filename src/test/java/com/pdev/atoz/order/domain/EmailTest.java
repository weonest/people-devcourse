package com.pdev.atoz.order.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class EmailTest {

    @DisplayName("올바른 형식의 이메일을 생성할 수 있다.")
    @Test
    void validateEmailAddressTest() {
        assertThatNoException().isThrownBy(() -> new Email("geonhee33@naver.com"));
    }

    @DisplayName("잘못된 형식의 이메일은 예외를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"geonhee33naver.com", "geonhee33@navercom", "geonhee33@naver..com"})
    void invalidMailAddressTest(String mailAddress) {
        assertThatThrownBy(() -> new Email(mailAddress))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
