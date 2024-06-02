package io.github.bonfimalan.simplified_monetary_transfer_system.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("Transaction")
public class Transaction {
    private String id;
    private String payer;
    private String payee;
    private double value;

    // TODO get this dates annotation
    private LocalDate creationDate;
    private LocalDate updateDate;
}
