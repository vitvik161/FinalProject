package org.example.server.processing.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Log
public class Controller {
    @GetMapping("/hosts")
    public String getHostsInfo() {
        return "{data: \"host 1001 is alive\"}";
    }

}
