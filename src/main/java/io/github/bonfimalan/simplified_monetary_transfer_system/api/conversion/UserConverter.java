package io.github.bonfimalan.simplified_monetary_transfer_system.api.conversion;

import io.github.bonfimalan.simplified_monetary_transfer_system.api.response.UserResponse;
import io.github.bonfimalan.simplified_monetary_transfer_system.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .document(user.getDocument())
                .balance(user.getBalance())
                .build();
    }

}
