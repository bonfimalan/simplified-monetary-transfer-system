package io.github.bonfimalan.simplified_monetary_transfer_system.validator;

import io.github.bonfimalan.simplified_monetary_transfer_system.domain.User;
import org.springframework.stereotype.Component;

import static io.github.bonfimalan.simplified_monetary_transfer_system.domain.UserType.BUSINESS;

@Component
public class TransactionValidator {

    public void validateTransaction(User payer, double transferredValue) {
        if (payer.getUserType() == BUSINESS) {
            throw new RuntimeException(); // TODO improve this handle
        }

        if (payer.getBalance() < transferredValue) {
            throw new RuntimeException(); // TODO improve this handle
        }
    }
}
