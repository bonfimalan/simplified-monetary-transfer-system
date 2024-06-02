package io.github.bonfimalan.simplified_monetary_transfer_system.api.exception;

public record ErrorMessageResponse(
        int status,
        String message
) {
}
