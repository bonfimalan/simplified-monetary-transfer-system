package io.github.bonfimalan.simplified_monetary_transfer_system.service;

import io.github.bonfimalan.simplified_monetary_transfer_system.api.request.DepositRequest;
import io.github.bonfimalan.simplified_monetary_transfer_system.domain.User;
import io.github.bonfimalan.simplified_monetary_transfer_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User getUser(String userId) {
        return repository.findById(userId)
                .orElseThrow(RuntimeException::new); // TODO handle better the exceptions
    }

    public User save(User user) {
        if (isNotEmpty(user.getId())) {
            return repository.save(user);
        }
        return createUser(user);
    }

    public Iterable<User> saveAll(List<User> user) {
        return repository.saveAll(user);
    }

    public User deposit(DepositRequest request) {
        var user = getUser(request.userId());
        user.addBalance(request.value());
        return save(user);
    }

    private User createUser(User user) {
        if(repository.findByDocumentOrEmail(user.getDocument(), user.getEmail()).isPresent()) {
            throw new RuntimeException(); // TODO change this to a conflict exception
        }

        return repository.save(user);
    }
}
