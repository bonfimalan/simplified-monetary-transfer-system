package io.github.bonfimalan.simplified_monetary_transfer_system.service;

import io.github.bonfimalan.simplified_monetary_transfer_system.domain.User;
import io.github.bonfimalan.simplified_monetary_transfer_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User getUser(String userId) {
        return repository.findById(userId)
                .orElseThrow(RuntimeException::new); // TODO handle better the exceptions
    }

    public User save(User user) {
        return repository.save(user);
    }

    public Iterable<User> saveAll(List<User> user) {
        return repository.saveAll(user);
    }
}
