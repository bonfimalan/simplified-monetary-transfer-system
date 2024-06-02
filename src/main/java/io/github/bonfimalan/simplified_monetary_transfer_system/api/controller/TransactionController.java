package io.github.bonfimalan.simplified_monetary_transfer_system.api.controller;

import io.github.bonfimalan.simplified_monetary_transfer_system.api.conversion.TransactionConverter;
import io.github.bonfimalan.simplified_monetary_transfer_system.api.request.TransactionRequest;
import io.github.bonfimalan.simplified_monetary_transfer_system.api.response.TransactionResponse;
import io.github.bonfimalan.simplified_monetary_transfer_system.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transfer")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;
    private final TransactionConverter converter;

    @PostMapping
    public TransactionResponse transfer(@RequestBody TransactionRequest request) {
        var transaction = converter.toTransaction(request);

        var savedTransaction = service.transfer(transaction);

        return converter.toResponse(savedTransaction);
    }
}
