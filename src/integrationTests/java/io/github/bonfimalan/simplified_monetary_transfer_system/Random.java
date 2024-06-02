package io.github.bonfimalan.simplified_monetary_transfer_system;

import net.datafaker.Faker;

public class Random {
    private static final Faker faker = new Faker();

    public static String cpf() {
        return faker.cpf().valid();
    }

    public static String cnpj() {
        return faker.cnpj().valid();
    }

    public static String email() {
        return faker.internet().emailAddress();
    }
}
