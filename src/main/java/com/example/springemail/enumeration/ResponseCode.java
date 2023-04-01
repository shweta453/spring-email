package com.example.springemail.enumeration;

public enum ResponseCode {
    SYSTEM(1),
    BUSINESS(2),
    DAO_DATABASE(3),
    COMMUNICATION(4),
    IO_FILE(5),
    SUCCESS(6),
    EMPTY(7);

    int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
