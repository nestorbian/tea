package com.jstu.tea.enums;

public enum Status {
    SUCCESS(1), FAIL(0);
    private int code;
    private Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
