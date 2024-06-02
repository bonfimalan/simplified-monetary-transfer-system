package io.github.bonfimalan.simplified_monetary_transfer_system.repository;

import io.github.bonfimalan.simplified_monetary_transfer_system.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByDocumentOrEmail(String document, String email);
}
