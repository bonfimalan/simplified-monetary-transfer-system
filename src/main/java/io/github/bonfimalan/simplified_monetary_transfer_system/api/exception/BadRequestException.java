package io.github.bonfimalan.simplified_monetary_transfer_system.api.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {
    private final String message;

    public BadRequestException(String message) {
        this.message = message;
    }
}
