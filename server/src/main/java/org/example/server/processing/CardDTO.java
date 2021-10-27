package org.example.server.processing;

import lombok.Value;

@Value
public class CardDTO {
    private final int id;
    private final int accid;
    private final String pan;
    private final int pin;
}
