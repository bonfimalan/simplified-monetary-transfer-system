package io.github.bonfimalan.simplified_monetary_transfer_system.api.request;

import io.github.bonfimalan.simplified_monetary_transfer_system.domain.UserType;

public record UserCreationRequest(
        String fullName,
        String document,
        String email,
        String password,
        UserType userType
) {
}
