package io.github.bonfimalan.simplified_monetary_transfer_system.repository.integration.test;

import io.github.bonfimalan.simplified_monetary_transfer_system.domain.User;
import io.github.bonfimalan.simplified_monetary_transfer_system.repository.UserRepository;
import io.github.bonfimalan.simplified_monetary_transfer_system.repository.integration.test.config.RepositoryIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.BDDAssertions.then;

public class UserRepositoryIT extends RepositoryIntegrationTest {
    @Autowired
    private UserRepository repository;

    @Test
    void should() {
        var user = new User();

        var savedUser = repository.save(user);

        then(savedUser.getId()).isNotEmpty();
    }
}
