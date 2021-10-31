package org.example.common;

import lombok.Value;

@Value
public class Request {
    private final String pan;
    private final int pin;
}
