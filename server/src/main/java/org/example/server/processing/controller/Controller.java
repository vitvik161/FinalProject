package org.example.server.processing.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.example.server.processing.CardDTO;
import org.example.server.processing.CustDTO;
import org.example.server.processing.service.CustService;
import org.springframework.web.bind.annotation.*;
import org.example.common.Response;
import org.example.common.Request;

import java.util.List;

@RestController
@AllArgsConstructor
@Log
public class Controller {

    private CustService custService;

    @GetMapping("/customers/{custId}")
    public CustDTO getByIdCustomerInfo(@PathVariable("custId") Long custId) {
        return custService.getCustDTO(custId);
    }

    @GetMapping("/customers")
    public List<CustDTO> getAllCustomersInfo() {
        return custService.getAllCustDTO();
    }

    @GetMapping("/cards/{cardPan}")
    public CardDTO getCardInfo(@PathVariable("cardPan") String cardPan) {
        return custService.getCardDTO(cardPan);
    }

    @PostMapping("/cards/getBalance")
    public Response getBalance(@RequestBody Request request) {
        log.info(request.toString());
        Response response = custService.getCardDTObalance(request.getPan(),request.getPin());
        log.info(response.toString());
        return response;
    }

}
