package io.github.bonfimalan.simplified_monetary_transfer_system.api.request;

public record TransactionRequest(
        double value,
        String payer,
        String payee
) {
}
