package io.github.bonfimalan.simplified_monetary_transfer_system.api.conversion;

import io.github.bonfimalan.simplified_monetary_transfer_system.api.request.TransactionRequest;
import io.github.bonfimalan.simplified_monetary_transfer_system.api.response.TransactionResponse;
import io.github.bonfimalan.simplified_monetary_transfer_system.domain.Transaction;
import io.github.bonfimalan.simplified_monetary_transfer_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionConverter {
    private final UserConverter userConverter;
    private final UserService userService;

    public TransactionResponse toResponse(Transaction transaction) {
        return TransactionResponse.builder()
                .id(transaction.getId())
                .value(transaction.getValue())
                .payer(userConverter.toResponse(userService.getUser(transaction.getPayer())))
                .payee(userConverter.toResponse(userService.getUser(transaction.getPayee())))
                .build();
    }

    public Transaction toTransaction(TransactionRequest request) {
        var transaction = new Transaction();
        transaction.setValue(request.value());
        transaction.setPayer(request.payer());
        transaction.setPayee(request.payee());
        return transaction;
    }

}
