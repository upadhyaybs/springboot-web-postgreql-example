package com.avarna.springboot.postgresql.example.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){
        super(message);
    }
}
