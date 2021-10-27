package org.example.server.processing;

import lombok.Value;

import java.util.List;

@Value
public class CustDTO {
    private final int id;
    private final String name;
    private final List<AccountDTO> accounts;
}
