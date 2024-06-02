package io.github.bonfimalan.simplified_monetary_transfer_system.api.controller;

import io.github.bonfimalan.simplified_monetary_transfer_system.api.conversion.UserConverter;
import io.github.bonfimalan.simplified_monetary_transfer_system.api.request.DepositRequest;
import io.github.bonfimalan.simplified_monetary_transfer_system.api.request.UserCreationRequest;
import io.github.bonfimalan.simplified_monetary_transfer_system.api.response.UserResponse;
import io.github.bonfimalan.simplified_monetary_transfer_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final UserConverter converter;

    @PostMapping
    @ResponseStatus(CREATED)
    public UserResponse create(UserCreationRequest creationRequest) {
        var userToBeCreated = converter.toEntity(creationRequest);

        var createdUser = service.save(userToBeCreated);

        return converter.toResponse(createdUser);
    }

    @PatchMapping("/deposit")
    public UserResponse deposit(DepositRequest creationRequest) {
        var updatedUser = service.deposit(creationRequest);

        return converter.toResponse(updatedUser);
    }

}
