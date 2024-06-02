package io.github.bonfimalan.simplified_monetary_transfer_system.service;

import io.github.bonfimalan.simplified_monetary_transfer_system.domain.Transaction;
import io.github.bonfimalan.simplified_monetary_transfer_system.repository.TransactionRepository;
import io.github.bonfimalan.simplified_monetary_transfer_system.validator.TransactionValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final UserService userService;
    private final TransactionValidator validator;
    private final TransactionRepository repository;

    public Transaction transfer(Transaction transaction) {
        var payer = userService.getUser(transaction.getPayer());
        validator.validateTransaction(payer, transaction.getValue());
        var payee = userService.getUser(transaction.getPayee());

        payer.setBalance(payer.getBalance() - transaction.getValue());
        payee.setBalance(payer.getBalance() + transaction.getValue());
        userService.saveAll(List.of(payer, payee));

        return repository.save(transaction);
    }
}
