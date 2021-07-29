package com.challenge.alura.exception;

import java.time.LocalDateTime;

public final class BadRequestExceptionDetailsBuilder {
    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime timestamp;

    private BadRequestExceptionDetailsBuilder() {
    }

    public static BadRequestExceptionDetailsBuilder aBadRequestExceptionDetails() {
        return new BadRequestExceptionDetailsBuilder();
    }

    public BadRequestExceptionDetailsBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BadRequestExceptionDetailsBuilder withStatus(int status) {
        this.status = status;
        return this;
    }

    public BadRequestExceptionDetailsBuilder withDetails(String details) {
        this.details = details;
        return this;
    }

    public BadRequestExceptionDetailsBuilder withDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
        return this;
    }

    public BadRequestExceptionDetailsBuilder withTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public BadRequestExceptionDetails build() {
        return new BadRequestExceptionDetails(title, status, details, developerMessage, timestamp);
    }
}
