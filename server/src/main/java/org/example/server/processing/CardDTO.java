package org.example.server.processing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Getter
@RequiredArgsConstructor
public class CardDTO {
    private final int id;
    private final int accid;
    private final String pan;
    private final int pin;
}
