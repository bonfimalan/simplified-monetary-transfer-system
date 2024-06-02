package io.github.bonfimalan.simplified_monetary_transfer_system.api.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String message;

    public NotFoundException(String message) {
        this.message = message;
    }
}
