package com.avarna.springboot.postgresql.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private int statusCode;
    private String statusDescription;
    private String errorMessage;
}
