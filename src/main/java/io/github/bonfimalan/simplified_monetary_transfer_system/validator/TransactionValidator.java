package io.github.bonfimalan.simplified_monetary_transfer_system.validator;

import io.github.bonfimalan.simplified_monetary_transfer_system.api.exception.BadRequestException;
import io.github.bonfimalan.simplified_monetary_transfer_system.domain.User;
import org.springframework.stereotype.Component;

import static io.github.bonfimalan.simplified_monetary_transfer_system.domain.UserType.BUSINESS;
import static java.lang.String.format;

@Component
public class TransactionValidator {

    public void validateTransaction(User payer, double transferredValue) {
        if (payer.getUserType() == BUSINESS) {
            throw new BadRequestException(format("User of type %s can't transfer money", BUSINESS));
        }

        if (payer.getBalance() < transferredValue) {
            throw new BadRequestException(format("User balance of %.2f is not enough to transfer  %.2f", payer.getBalance(), transferredValue));
        }
    }
}
