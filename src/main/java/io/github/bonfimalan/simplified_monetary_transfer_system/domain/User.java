package io.github.bonfimalan.simplified_monetary_transfer_system.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("User")
public class User {
    @Id
    private String id;
    private String fullName;
    private String document;
    private String email;
    private String password;
    private UserType userType;
    private double balance;

    public void addBalance(double value) {
        this.balance += value;
    }

    public void removeBalance(double value) {
        this.balance -= value;
    }
}
