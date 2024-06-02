package io.github.bonfimalan.simplified_monetary_transfer_system.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("User")
public class User extends BaseEntity {
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
