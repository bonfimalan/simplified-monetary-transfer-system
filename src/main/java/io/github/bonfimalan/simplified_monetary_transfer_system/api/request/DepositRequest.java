package io.github.bonfimalan.simplified_monetary_transfer_system.api.request;

public record DepositRequest(
        double value,
        String userId
) {
}
