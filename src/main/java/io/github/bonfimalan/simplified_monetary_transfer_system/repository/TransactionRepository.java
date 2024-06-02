package io.github.bonfimalan.simplified_monetary_transfer_system.repository;

import io.github.bonfimalan.simplified_monetary_transfer_system.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
}
