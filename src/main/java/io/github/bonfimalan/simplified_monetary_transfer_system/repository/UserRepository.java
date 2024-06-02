package io.github.bonfimalan.simplified_monetary_transfer_system.repository;

import io.github.bonfimalan.simplified_monetary_transfer_system.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByDocumentOrEmail(String document, String email);
}
