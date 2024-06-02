package io.github.bonfimalan.simplified_monetary_transfer_system.api.exception;

import lombok.Getter;

@Getter
public class ConflictException extends RuntimeException {
    private final String message;

    public ConflictException(String message) {
        this.message = message;
    }
}
