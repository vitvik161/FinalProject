package org.example.server.processing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class AccountDTO {
    private final int id;
    private final int custid;
    private final int balance;
    private final List<CardDTO> cardDTO;
}
