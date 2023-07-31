package com.pdev.atoz.global.exception;

public class DuplicateValueException extends RuntimeException {
    private static final String MESSAGE = "중복된 값이 존재합니다.";
    private final String field;

    public DuplicateValueException(String field) {
        super(MESSAGE);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
