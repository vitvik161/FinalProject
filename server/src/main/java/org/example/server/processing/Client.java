package org.example.server.processing;

import lombok.Value;

import java.util.List;

@Value
public class Client {
    private final int id;
    private final int pin;
    private final List<Account> accounts;
}
