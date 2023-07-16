package com.aaronbujatin.delorianhotelbackend.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
