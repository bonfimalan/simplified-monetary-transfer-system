package io.github.bonfimalan.simplified_monetary_transfer_system.repository;

import io.github.bonfimalan.simplified_monetary_transfer_system.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
