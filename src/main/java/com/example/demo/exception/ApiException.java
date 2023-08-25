package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

//the client will see
public record ApiException(
        String message,
        Throwable throwable,
        HttpStatus httpStatus,
        ZonedDateTime zonedDateTime
) { }
