package com.topwears.topwears.exceptions;

public class InvalidRegistrationDetailsException extends RuntimeException {
    private String message;
    public InvalidRegistrationDetailsException(String message) {
        super(message);
        this.message=message;

    }

    public InvalidRegistrationDetailsException() {
        this.message="Invalid registration information";

    }
}
