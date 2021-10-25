package org.example.server.processing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Account {
    private final int accountId;
    private final int balance;
}
