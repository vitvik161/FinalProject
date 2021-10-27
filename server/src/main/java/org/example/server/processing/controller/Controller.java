package org.example.server.processing.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.example.server.processing.CustDTO;
import org.example.server.processing.service.CustService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@Log
public class Controller {

    private CustService custService;

    @GetMapping("/hosts")
    public String getHostsInfo() {
        return "{data: \"host 1001 is alive\"}";
    }

    @GetMapping("/hosts/{hostId}/customers/{custId}")
    public CustDTO getClientsInfo(@PathVariable Long hostId, @PathVariable("custId") Long custId) {
        if (hostId != 1) {
            throw new RuntimeException();
        }
        log.info("custId = "+custId);
        return custService.getCustDTO(custId);


    }


}
