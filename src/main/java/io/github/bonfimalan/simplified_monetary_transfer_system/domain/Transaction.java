package io.github.bonfimalan.simplified_monetary_transfer_system.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("Transaction")
public class Transaction extends BaseEntity {
    private String payer;
    private String payee;
    private double value;
}
