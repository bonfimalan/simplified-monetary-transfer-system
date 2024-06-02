package io.github.bonfimalan.simplified_monetary_transfer_system.api.response;

import lombok.Builder;

@Builder
public record TransactionResponse(
        String id,
        double value,
        UserResponse payer,
        UserResponse payee
) {

}
