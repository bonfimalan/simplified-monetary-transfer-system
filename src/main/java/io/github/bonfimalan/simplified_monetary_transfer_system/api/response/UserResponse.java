package io.github.bonfimalan.simplified_monetary_transfer_system.api.response;

import lombok.Builder;

@Builder
public record UserResponse(
        String id,
        String fullName,
        String email,
        String document,
        double balance
) {
}
