package com.challenge.alura.handler;

import com.challenge.alura.exception.BadRequestException;
import com.challenge.alura.exception.BadRequestExceptionDetailsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetailsBuilder> handlerBadRequestException(BadRequestException bre) {
        return new ResponseEntity(
                BadRequestExceptionDetailsBuilder.aBadRequestExceptionDetails()
                        .withTimestamp(LocalDateTime.now())
                        .withStatus(HttpStatus.BAD_REQUEST.value())
                        .withTitle("Bad Request Exception")
                        .withDetails(bre.getMessage())
                        .withDeveloperMessage(bre.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST
        );
    }
}
